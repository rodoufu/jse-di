package ${groupId}.cdi;

import java.io.Serializable;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

/**
 * Interceptor to create a transaction.
 * @author rodoufu
 */
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {
	private static final long serialVersionUID = -8047414402547864361L;

	private transient @Inject Instance<EntityManager> manager;

	/**
	 * Creates a transaction arround the method.
	 * @param context CDI context.
	 * @return The returned value.
	 * @throws Exception In case of any error.
	 */
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		final EntityTransaction trx = manager.get().getTransaction();
		boolean criador = false;
		try {
			if (!trx.isActive()) {
				trx.begin();
				trx.rollback();
				trx.begin();
				criador = true;
			}
			return context.proceed();
		} catch (Exception e) {
			if (trx != null && criador) {
				trx.rollback();
			}
			throw e;
		} finally {
			if (trx != null && trx.isActive() && criador && !trx.getRollbackOnly()) {
				trx.commit();
			}
		}
	}

}
