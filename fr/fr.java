public class Dog extends RealmObject {
  private String name;
  private int age;

}

public class Person extends RealmObject {
  @PrimaryKey
  private long id;
  private String name;
  private RealmList<Dog> dogs;

}

Dog dog = new Dog();
dog.setName("Rex");
dog.setAge(1);

Realm.init(context);

Realm realm = Realm.getDefaultInstance();

final RealmResults<Dog>puppies = realm.where(Dog.class).lessThan("age", 2).findAll
puppies.size();

realm.beginTransation();
final Dog managedDog = realm.copyToRealm(dog);
Person person = realm.createObject(Person.class);
person.getDogs().add(managedDog);
realm.commitTransaction();

puppeis.addChangeListener(new OrderedRealmColectionChangeListener<RealmResults<Dog>>(){
  @Override
  public void onChange(RealmResults<Dog> results, OrderedCollectionChangeSet changeSet){
    changeSet.getInsertions();
  }
});

realm.executeTransactionAsync(new Realm.Transaction(){
  @Override
  public void execute(Realm bgRealm){
    Dog dog = bgRealm.where(Dog.class).equalTo("age", 1).findFrist();
    dog.setAge(3);
  }
}, new Realm.Transaction.OhSuccess(){
  @Override
  public void onSuccess(){
    puppies.size();
    managedDog.getAge();
  }
});




