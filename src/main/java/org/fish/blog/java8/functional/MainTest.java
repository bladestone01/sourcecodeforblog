package org.fish.blog.java8.functional;

import java.util.function.Function;

public class MainTest {

	public String add(String str, Hello hello) {
		return hello.msg(str);
	}
	
	public String add(String str, Function<String, String> fn) {
		return fn.apply(str);
	}
	
	public static void main(String[] args) {
		case1();
		case2();
		case3();
		case4();
	}

	public static void case1() {
		Hello hello = param -> param + "world!";
		String msg = new MainTest().add("hello,", hello);
		
		System.out.println("msg=>" + msg);
		
	}
	
	public static void case2() {
		Function<String, String> fn = param -> param + ",world";
		String result = new MainTest().add("hello", fn);
		
		System.out.println("info=>" + result);
	}
	
	public static void case3() {
		Hello hello = param -> param + "world!";
        Hello hello2 = new Hello() {
			@Override
			public String msg(String info) {
				return info + ",world";
			}
        };
		System.out.println("test functional:" + hello.msg("hello,"));
		System.out.println("test functional:" + hello2.msg("hello,"));
	}
	
	public static void case4() {
	   TwoParamFn fn = (p1, p2)-> p1.toUpperCase() + "," + p2.toUpperCase();
	   
	   System.out.println("two params:" + fn.add("hello", "world"));
	}
}
