/**
 * 
 */
package com.jellywrap.conekta.query;

import java.util.List;
import java.util.Set;

import org.apache.http.NameValuePair;

import com.jellywrap.conekta.rest.RequestParam;

/**
 * @author Jesus Mata
 *
 */
public class QueryBuilder {

    /** Map that will store the params to **/
    private Set<NameValuePair> params;

    public QueryBuilder eq(String field, String value) {
	params.add(new RequestParam(field, value));
	return this;
    }

    public QueryBuilder gt(String field, String value) {
	params.add(new RequestParam(field + ".gt", value));
	return this;
    }

    public QueryBuilder gte(String field, String value) {
	params.add(new RequestParam(field + ".gte", value));
	return this;
    }

    public QueryBuilder lt(String field, String value) {
	params.add(new RequestParam(field + ".lt", value));
	return this;
    }

    public QueryBuilder lte(String field, String value) {
	params.add(new RequestParam(field + ".lte", value));
	return this;
    }

    public QueryBuilder ne(String field, String value) {
	params.add(new RequestParam(field + ".ne", value));
	return this;
    }

    public QueryBuilder in(String field, String... values) {
	for (String value : values) {
	    params.add(new RequestParam(field + ".in[]", value));
	}

	return this;
    }

    public QueryBuilder in(String field, List<String> values) {
	for (String value : values) {
	    params.add(new RequestParam(field + ".in[]", value));
	}
	return this;
    }

    public QueryBuilder nin(String field, List<String> values) {
	for (String value : values) {
	    params.add(new RequestParam(field + ".nin[]", value));
	}
	return this;
    }

    public QueryBuilder nin(String field, String... values) {
	for (String value : values) {
	    params.add(new RequestParam(field + ".nin[]", value));
	}

	return this;
    }

    public QueryBuilder regex(String field, String regex) {
	params.add(new RequestParam(field + ".regex", regex));
	return this;
    }

    public QueryBuilder limit(int limit) {
	params.add(new RequestParam("limit", Integer.toString(limit)));
	return this;
    }

    public QueryBuilder offset(int offset) {
	params.add(new RequestParam("offset", Integer.toString(offset)));
	return this;
    }

    public QueryBuilder sort(String field, SortDirection dir) {
	params.add(new RequestParam("sort", field + "." + dir.getDirection()));
	return this;
    }

    public QueryBuilder sort(Sort... sorts) {
	for (Sort sort : sorts) {
	    params.add(new RequestParam("sort[]", sort.getField() + "." + sort.getDirection()));
	}
	return this;
    }

    public static class Sort {

	private String field;
	private SortDirection sortDirection;

	/**
	 * @param field
	 * @param sortDirection
	 */
	public Sort(String field, SortDirection sortDirection) {
	    super();
	    this.field = field;
	    this.sortDirection = sortDirection;
	}

	/**
	 * @return the field
	 */
	public String getField() {
	    return field;
	}

	/**
	 * @return the sortDirection
	 */
	public String getDirection() {
	    return sortDirection.getDirection();
	}

    }
}
