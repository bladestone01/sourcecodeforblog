package org.fish.blog.java8.functional;

/**
 * Functional Test in Heritage.
 * 
 * @author chenjunfeng1
 *
 */
public class InheritTest {
	public static void main(String[] args) {
        Child1 child1 = param -> param.toLowerCase();
        
        InheritTest t1 = new InheritTest();
        t1.test("Hello,", child1);
        System.out.println("info=>"  + child1.msg("Hello"));
        
        Child1 child2 = new MyChild1();
        System.out.println("MyChild1=>" + child2.msg("WorlD,"));
	}
	
	public void test(String info, Child1 fn) {
		fn.defaultFunction1(info);
	}
	
	public String test1(String info, Child1 fn) {
		return fn.msg(info);
	}

	public static class MyChild1 implements Child1 {
		@Override
		public String msg(String info) {
			return "hello, " + info;
		}
	}
	
	@FunctionalInterface
	public interface Parent {
		String msg(String info);
	}
	
	@FunctionalInterface
	public interface Child1 {
		String msg(String info);
		default void defaultFunction1(String msg) {
			System.out.println("default function1 msg=>" + msg);
		}
	}
	
	@FunctionalInterface
	public interface Child2 {
		String msg(String info);
		default void defaultFunction2(String msg) {
			System.out.println("default function2 msg=>" + msg);
		}
	}
	
	
}
