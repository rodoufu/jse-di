package com.gitlab.rodoufu.jsedi.cdi;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.weld.environment.se.WeldSEBeanRegistrant;
import org.jboss.weld.environment.se.contexts.ThreadContext;

@Interceptor
@CreateThreadScope
public class ThreadScopedInterceptor implements Serializable {
	private static final long serialVersionUID = 2248823328027432879L;

	private ThreadContext threadContext;

	@Inject
	public ThreadScopedInterceptor(WeldSEBeanRegistrant extension) {
		this.threadContext = extension.getThreadContext();
	}

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		boolean isCreator = false;
		try {
			if (!threadContext.isActive()) {
				threadContext.activate();
				isCreator = true;
			}
			return context.proceed();
		} finally {
			if (isCreator) {
				threadContext.invalidate();
				threadContext.deactivate();
			}
		}
	}

	public static void createThreadScope(ThreadContext threadContext, Runnable runnable) {
		boolean isCreator = false;
		try {
			if (!threadContext.isActive()) {
				threadContext.activate();
				isCreator = true;
			}
			runnable.run();
		} finally {
			if (isCreator) {
				threadContext.invalidate();
				threadContext.deactivate();
			}
		}
	}

}
