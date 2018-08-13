import java.lang.invoke.Stable

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class CreateJSONObj {

	static main(args) {
		def uId = 21
		def uidKey = "userId"
		def json1 = new JsonBuilder()
		def root1 = json1 {
			"${uidKey}" uId
		}
		
		def map1 = [firstname:"sunil", lastname:"rao"]
		//json1.call(map1)
		
		def json2 = new JsonBuilder()
		def root2 = json2 userName:"Sai", age:30, email:"email@mail.com"
		println json1.toPrettyString()
		println "---------------------------------- 1"
		println json2.toPrettyString()
		
		
		def parsedJson = new JsonSlurper().parseText(json1.toString())
		println " ------------------------------------ 2"
		def json3 = new JsonBuilder(parsedJson)
		 
		println json3.toPrettyString()
		//  Two merge JSON Objects not working
		//println JsonOutput.prettyPrint(JsonOutput.toJson(map1,json1))
		
	}

	static def printSomething(){
		"Printing something"
	}
	
}
