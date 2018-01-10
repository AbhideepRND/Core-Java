package com.designpattern.example.bridgepattern;

public abstract class GenericDao<P extends Audit> {

		protected JDBCTemplate<P> template;
		
		public void initAuditValues(Audit audit) {
			audit.setUser("system");
		}
		
		public abstract boolean mergeEntity( P entity );
		
		public GenericDao(JDBCTemplate<P> template ){
				this.template = template;
		}
		
}
