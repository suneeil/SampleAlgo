import groovyjarjarantlr.MakeGrammar

import org.codehaus.groovy.runtime.InvokerHelper


class Main {

	static main(args) {
	
	def code = {123}
	assert code() == 123
	println "Done"
		
		
	def isOdd = {i -> i%2 != 0 }
	assert isOdd(3) == true
	println "Is Odd"
	
	def isEven = {it%2 == 0}
	assert isEven(4) == true
	println "Is Even"
	
	def makeUpperCase = {String str -> println str.toUpperCase()}
		
	makeUpperCase("sai ram")
	}
	
	
	
}
