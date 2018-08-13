package com.pratice.java8Examples;

import java.util.function.Function;

public class FunctionIdentityExample {

	public static void main(String[] args) {
		Function<Integer, Integer> id = Function.identity();
		System.out.println(id.apply(200000000));

	}

}
