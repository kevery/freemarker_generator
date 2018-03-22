package com.fb.bir.pojo;

/**
 * ${comment}
 */
public class ${domain} {
	<#list columns as col>
    /**
     * ${col["comment"]}
     */
	private ${col["javaType"]} ${col["javaName"]};

	</#list>

}
