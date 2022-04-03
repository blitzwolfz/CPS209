/*
 * A simple program to test the class Person.
 */
public class QO2 
{

	public static void main(String[] args) {

		Person rachel = new Person("Rachel");
		Person joey 	= new Person("Joey");
		Person ross 	= new Person("Ross");
		Person monica = new Person("Monica");
		Person chandler = new Person("Chandler");
		Person phoebe 	= new Person("Phoebe");

		rachel.addFriend(joey);
		rachel.addFriend(ross);
		rachel.addFriend(monica);
		rachel.addFriend(chandler);
		rachel.addFriend(phoebe);

		joey.addFriend(rachel);
		joey.addFriend(ross);
		joey.addFriend(monica);
		joey.addFriend(chandler);
		joey.addFriend(phoebe);

		System.out.println(rachel.friendsInCommon(joey));
		System.out.println(joey.friendsInCommon(rachel));

		rachel.delFriend(monica);
		System.out.println(rachel.friendsInCommon(joey));
		rachel.delFriend(chandler);
		System.out.println(rachel.friendsInCommon(joey));
		rachel.delFriend(phoebe);
		System.out.println(rachel.friendsInCommon(joey));
		rachel.delFriend(ross);
		System.out.println(rachel.friendsInCommon(joey));
		
		System.out.println("Expected:\nRoss Monica Chandler Phoebe\nRoss Monica Chandler Phoebe\nRoss Chandler Phoebe\nRoss Phoebe\nRoss");
	}
}
