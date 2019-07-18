/**
 * 
 */
package com.alex.testcompare;

import java.util.Comparator;

public class DomainComparator implements Comparator<Domain>
{
	@Override
	public int compare(Domain domain1, Domain domain2)
    {
        if (domain1.getStr().compareTo(domain2.getStr()) > 0)
            return 1;
        else if (domain1.getStr().compareTo(domain2.getStr()) == 0)
            return 0;
        else 
            return -1;
    }
    
}
