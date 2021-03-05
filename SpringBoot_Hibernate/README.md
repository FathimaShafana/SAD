a)	It takes exactly 10 seconds in test cache when the timeToLiveSeconds was set to 10. And it was delayed to 20 seconds when it was set to 20.
Since, the entities are loaded and available at the cache, it does not run sql query again. This is determined by the timeToLiveSeconds
![](https://github.com/FathimaShafana/SAD/blob/main/SpringBoot_Hibernate/Lab03_Snaps/CacheTime.JPG?raw=true)
![](https://github.com/FathimaShafana/SAD/blob/main/SpringBoot_Hibernate/Lab03_Snaps/Cachetme.JPG?raw=true)

b)	Now user table has the foreign key of emp_id of Employee table
![](https://github.com/FathimaShafana/SAD/blob/main/SpringBoot_Hibernate/Lab03_Snaps/user%20table%20FK.JPG?raw=true)

c)	Cascade.REMOVE and orphanRemoval=true are two options for removing entities from the database. orphanRemoval= true is commonly used in OneToMany or OneToOne. This is used when we need to remove the children objects automatically from the database when its parent objects are removed.
Here in this repository,
Employee and Leaves are mapped by OneToMany relationship. If the particular employee is removed from the database, all his associated leaves will be deleted from the database since his leaves have no meaning without his parent employee. Thus, orphanRemoval is set to true.
The orphanRemoval is applied only to the disassociated children, but the cascade.remove  applies the remove operation from parent to all its child entities.
![](https://github.com/FathimaShafana/SAD/blob/main/SpringBoot_Hibernate/Lab03_Snaps/cascaderemove.JPG?raw=true)

d)	By default, JPA sets EmployeeToAddress and EmployeeToBenefits as Lazy Initialization since both are in OneToMany and ManyToMany relationship since the eager initialization would be computationally costly. By setting them as EAGER, the following changes were noticed and the time for loading the entities were more than that of eager initialization:
Eager Initialization
![](https://github.com/FathimaShafana/SAD/blob/main/SpringBoot_Hibernate/Lab03_Snaps/eager1.JPG?raw=true)

Lazy Initialization
![](https://github.com/FathimaShafana/SAD/blob/main/SpringBoot_Hibernate/Lab03_Snaps/lazy1.JPG?raw=true)
e)	 When the cascadeType.all and orphanRemoval=true was removed, it means when few entities are removed the associated entities still appear in database. 
When, testCascadeRemove was performed, it throws DataIntegrityViolationException while testCascadePersist returns an error that object references an unsaved transient instance since few entities are removed leaving entities orphan.

f)	The transactional annotation for testFetch was removed and it caused no errors. But, when @Transactional of testCascadePersist , testCascadeRemove and testCreateLeave were removed, it throws javax.persistence.TransactionRequiredException. 
The javax.persistence.PersistenceContext is transactional by default unless otherwise specified. Thus, it causes an error. 
Further, these operations need to be atomic thus, to be performed as a single transaction. Thus, the call for persist and remove are not made.
![](https://github.com/FathimaShafana/SAD/blob/main/SpringBoot_Hibernate/Lab03_Snaps/persisterror.JPG?raw=true)

g) and h) Codes modified
