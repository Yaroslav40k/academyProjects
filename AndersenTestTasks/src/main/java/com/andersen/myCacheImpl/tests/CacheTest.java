package com.andersen.myCacheImpl.tests;

import org.junit.Assert;

import com.andersen.myCacheImpl.Cache;

import static org.hamcrest.core.Is.is;

/*Test Class, contains  filling methods to prepare  the Cache for further testing */

public abstract class CacheTest extends Assert
{
    @SuppressWarnings("rawtypes")
	public abstract Cache getCache();

    /*Fills whole Cash*/
    @SuppressWarnings( "unchecked" )
    public void fillCache()
    {
        for( int i = 0; i < getCache().getCapacity(); i++ ) {
            getCache().put( i, i );
        }
        assertThat( getCache().getSize(), is( getCache().getCapacity() ) );
    }

    /*Adds one K/V Cash*/
    @SuppressWarnings( "unchecked" )
    public void putToCache( Integer key, Object val )
    {
        getCache().put( key, val );
        assertThat( getCache().get( key ), is( val ) );
    }
}

