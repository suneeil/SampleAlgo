/*
class IdentityClosureEx {
	
	class Person {
		String firstName
		int age
		String occupation
		String hometown
	  }
	
	  static  testIdentityClosure() {
		def personMapAttributes = ["firstName": "Nirav", "age":33,
  "occupation": "developer", "hometown":"Pittsburgh"]
		Person person = new Person()
		person.identity {
		  firstName = personMapAttributes.name
		  age = personMapAttributes.age
		  occupation = personMapAttributes.occupation
		  hometown = personMapAttributes.hometown
		}
		println person.dump()
	  }
}
*/