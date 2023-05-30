package week9.DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class ListTestingModel {
	//protected enum LIST_TYPES {ArrayList, LinkedList, TreeSet, HashSet};
	protected enum COLLECTION_TYPES {ArrayList, LinkedList, HashSet, TreeSet};
	protected enum WHERE_CHOICES {Start, Middle, End};
	
	/**
	 * Run the defined test, returning the total elapsed time in seconds
	 * @param amountOfData The amount of elements to add to the list
	 * @param listType The type of list to use
	 * @param whereChoice Where to insert the elements in the list
	 * @return the elapsed time in seconds, as a float
	 */
	public float runTest(Integer amountOfData, COLLECTION_TYPES collectionType, WHERE_CHOICES whereChoice) {
		SampleData[] data = createData(amountOfData);		
		//List<SampleData> list = createList(amountOfData, listType);
		Collection<SampleData> collection = createCollection(amountOfData,collectionType);
		
		// Perform the test
		long startTime = System.currentTimeMillis();
		//addDataToList(data, list, whereChoice);
		addDataToCollection(data, collection, whereChoice);
		long endTime = System.currentTimeMillis();
		return (endTime - startTime) / 1000.0f;
	}
	public float runFindTest(int amountOfData, COLLECTION_TYPES collectionType, SampleData selectedObject) {
	    // to Create the data objects
	    SampleData[] data = createData(amountOfData);
	    Collection<SampleData> collection = createCollection(amountOfData, collectionType);

	    // Perform the find test
	    addDataToCollection(data, collection, WHERE_CHOICES.Start); // Add data to the collection
	    long startTime = System.currentTimeMillis();
	    boolean found = findSelectedObjectInCollection(selectedObject, collection);
	    long endTime = System.currentTimeMillis();

	    return (endTime - startTime) / 1000.0f;
	}

	
	private boolean findSelectedObjectInCollection(SampleData selectedObject, Collection<SampleData> collection) {
	    return collection.contains(selectedObject);
	}

//-----------------------------------------------------------------------------------------------------------------------------
	private SampleData[] createData(Integer amountOfData) {
		SampleData[] data = new SampleData[amountOfData];
		for (int i = 0; i < amountOfData; i++) data[i] = new SampleData();
		return data;
	}
    private Collection<SampleData> createCollection(int amountOfData, COLLECTION_TYPES collectionType) {
        // Create an empty collection of the desired type
        Collection<SampleData> collection = null;
        if (collectionType == COLLECTION_TYPES.ArrayList)
            collection = new ArrayList<>();
        else if (collectionType == COLLECTION_TYPES.LinkedList)
            collection = new LinkedList<>();
        else if (collectionType == COLLECTION_TYPES.HashSet)
            collection = new HashSet<>();
        else if (collectionType == COLLECTION_TYPES.TreeSet)
            collection = new TreeSet<>();
        return collection;
    }

    private void addDataToCollection(SampleData[] data, Collection<SampleData> collection, WHERE_CHOICES whereChoice) {
        for (SampleData element : data) {
            int index = 0; // Assume WHERE_CHOICES.Start
            if (whereChoice == WHERE_CHOICES.Middle)
                index = collection.size() / 2;
            else if (whereChoice == WHERE_CHOICES.End)
                index = collection.size();

            if (collection instanceof List) {
                List<SampleData> list = (List<SampleData>) collection;
                list.add(index, element);
            } else {
                collection.add(element);
            }
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    private void addDataToCollection(SampleData[] data, Collection<SampleData> collection) {
        collection.addAll(Arrays.asList(data));
    }
    //----------------------------------------------------------------------------------------------------------------
}
