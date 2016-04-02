package com.codemanship.becausemock;

public class Mock {
		
		public MockMemory memory;
		
		public void verify(){
			memory.verify();
		}

		public void setMemory(MockMemory memory) {
			this.memory = memory;
		}

		public void thenReturn(Object value) {
			memory.thenReturn(value);
		}

		public void when() {
			memory.when();
		}

	}


