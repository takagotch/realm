//create
public class Dog extends RealmObject {
  private String name;
  private int
  @ignored private int dontPersistMe;

}

//save
Realm realm = Realm.getInstance(this.getContext());

realm.beginTransaction();
Dog dog = realm.createObject(Dog.class);
dog.setNme("Rex");
dog.setAge(3);
realm.commitTransaction();

realm.executeTransaction(new Realm.Transaction(){
  @Override
  public void execute(Realm realm){
    Dog dog = realm.createObject(Dog.class);
    dog.setName("Rex");
    dog.setAge(3);
  }
});

//query
RealmResults<Dog> query = realm.where(Dog.class)
  .greaterThan("age", 8)
  .findAll();

RealmResults<Dog> allRex = query.where()
	.contains("name", "Rex")
	.findAll();

//delete
realm.beginTransactoin();
query.deleteFirstFromRealm();
query.deleteLastFromRealm();
realm.commitTransaction()





