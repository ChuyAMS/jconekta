/**
 * 
 */
package com.jellywrap.conekta.query;

/**
 * @author Jesus Mata
 *
 */
public enum SortDirection {
    ASC("asc"), DESC("desc");

    private String direction;

    /**
     * @param direction
     */
    private SortDirection(String direction) {
	this.direction = direction;
    }

    public String getDirection() {
	return direction;
    }
}
