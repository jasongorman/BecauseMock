package com.codemanship.becausemock;

public class Mock {
		
		private MockMemory memory;
		
		public void thenReturn(Object value) {
			memory.thenReturn(value);
		}
		
		void verify(){
			memory.verify();
		}

		void setMemory(MockMemory memory) {
			this.memory = memory;
		}

		void when() {
			memory.when();
		}

	}


