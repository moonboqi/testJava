/**
 * 
 */
package com.alex.testcompare;

public class Domain implements Comparable<Domain>
{
    private String str;

    public Domain(String str)
    {
        this.str = str;
    }

    public String getStr()
    {
        return str;
    }

	@Override
	public int compareTo(Domain domain)
    {
        if (this.str.compareTo(domain.str) > 0)
            return 11;
        else if (this.str.compareTo(domain.str) == 0)
            return 0;
        else 
            return -11;
    }
}
