/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo4;


import Business.Business.Business;
import Business.Business.ConfigureABusiness;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;
import com.db4o.ta.TransparentPersistenceSupport;



//Utility class for Managing Database Object 
public class Db4oUtil
{
    //Should have file Directory -
    private static final String FILENAME = "c:\\temp\\CarterAlbert08-Assignment-EnterpriseExtensions.db4o"; //this is the filename
    //that the file will be stored under. 
    // the \\ tells what directory it should be stored under,
    //in the project main folder.
    //ta's will need the file to check! so might as well store in the project folder.
    
    //for some reason, relative paths don't work.

    private static ObjectContainer _container = null;

    public synchronized static ObjectContainer getObjectContainer() {
    	if (_container == null ||
                _container.ext().isClosed() )
             {
    		_container  = getObjectContainerForFilename(FILENAME);
             }
                return _container;
    }

    protected synchronized static void shutdown() {
        if (_container != null){
        	_container.close();
        }
    }

        public static ObjectContainer getObjectContainerForFilename(String filename) {
        try{

        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().add(new TransparentPersistenceSupport());
        //Controls the number of objects in memory
        config.common().activationDepth(Integer.MAX_VALUE);
        //Controls the depth/level of updation of Object
        config.common().updateDepth(Integer.MAX_VALUE);

        //Register your top most Class here
        config.common().objectClass(Business.class).cascadeOnUpdate(true);

        ObjectContainer db = Db4oEmbedded.openFile(config, filename);
        return db;
        }
            catch(Exception ex)
            {
                System.out.print(ex.getMessage());
            }
        return null;
    }

    public static void storeObject(Object o){
        getObjectContainer().store(o);//store says to put the changes into the cache, but not on the drive
        getObjectContainer().commit(); //commit says to store the changes to the drive
        //we aren't using roll back, but what it does is revert the changes stored
        //to the last commit.
    }

    public static Business getBusiness(){ 
        Query queryCS =getObjectContainer().query();
        queryCS.constrain(Business.class);
        ObjectSet<Business> businessList = queryCS.execute();
        Business business = null;
        if(businessList.isEmpty()){//creates just one business object.
        //we can only have one object because if there are two, the program will get
            //confused and crash
            
            // Call the intialize method of configureBusiness here
            
            //if the list is empty, we'll create a new business
            business = ConfigureABusiness.Initialize("initialization");
            storeObject(business);
            return business;
        } //otherwise, we'll just get the existing business.
        business = businessList.get(0);
        return business;

    }

}

