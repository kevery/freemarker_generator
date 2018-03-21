<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.fb.bir.dao.${domain}Mapper">
    <resultMap id="BaseResultMap" type="com.fb.bir.pojo.${domain}">

        <#list columns as col>
            <id column="${col["name"]}" property="${col["javaType"]}" jdbcType="${col["jdbcType"]}"/>
        </#list>

    </resultMap>

    <sql id="Base_Column_List">
        <#list columns as col>
            <#if col_has_next>${col["name"]},<#else>${col["name"]}</#if>
        </#list>
    </sql>

    <select id="selectPk" resultMap="BaseResultMap"
            parameterType="java.lang.Long">
        select
        <include refid="Base_Column_List"/>
        from fb_${table_name}
        where id = ${r"#{"}id,jdbcType=BIGINT}
    </select>


    <!-- 更新对象 -->
    <update id="update" parameterType="com.fb.bir.pojo.${domain}">
        update fb_${table_name}
        <set>
            <#list columns as col>
                <#if col_has_next>
                <if test="${col["javaType"]} != null">${col["name"]}=${r"#{"}${col["javaName"]},jdbcType=${col["jdbcType"]}},</if>
                <#else>
                <if test="${col["javaType"]} != null">${col["name"]}=${r"#{"}${col["javaName"]},jdbcType=${col["jdbcType"]}}</if>
                </#if>
            </#list>

        </set>
        <where>
            <if test="id != null">
                id = ${r"#{"}id,jdbcType=BIGINT}
            </if>
        </where>
    </update>

    <!-- 更新对象（参数） -->
    <update id="updateParam" parameterType="java.util.Map">
        update fb_${table_name}
        <set>
            <#list columns as col>
                <#if col_has_next>
                <if test="${col["javaType"]} != null">${col["name"]}=${r"#{"}${col["javaName"]},jdbcType=${col["jdbcType"]}},</if>
                <#else>
                <if test="${col["javaType"]} != null">${col["name"]}=${r"#{"}${col["javaName"]},jdbcType=${col["jdbcType"]}}</if>
                </#if>
            </#list>
        </set>
        <where>
            <if test="id != null">
                id = ${r"#{"}id,jdbcType=BIGINT}
            </if>
        </where>
    </update>

    <select id="count" resultType="int">
        select count(*) from fb_${table_name} e
    </select>


    <select id="countParam" parameterType="java.util.Map" resultType="int">
        select count(*) from fb_${table_name} e
        <where>
            <#list columns as col>
                <#if col_index==0>
                <if test="${col["javaName"]} != null">${col["name"]} = ${r"#{"}${col["javaName"]}}</if>
                <#else>
                and <if test="${col["javaName"]} != null">${col["name"]} = ${r"#{"}${col["javaName"]}}</if>
                </#if>
            </#list>

        </where>
    </select>

    <!-- 查询（参数） -->
    <select id="selectParam" parameterType="java.util.Map" resultMap="BaseResultMap">
        select * from fb_${table_name}
        <where>
            <#list columns as col>
                <#if col_index==0>
                <if test="${col["javaName"]}!= null">${col["name"]} = ${r"#{"}${col["javaName"]}}</if>
                <#else>
                and <if test="${col["javaName"]}!= null">${col["name"]} = ${r"#{"}${col["javaName"]}}</if>
                </#if>
            </#list>
        </where>
        <if test="orderColumn != null">
            order by ${r"${"}orderColumn}
            <if test="orderTurn != null">
            ${r"${"}orderTurn}
            </if>
        </if>
    </select>


    <delete id="delete" parameterType="java.lang.Long">
        delete from
        fb_${table_name}
        where id = ${r"#{"}id,jdbcType=BIGINT}
    </delete>

    <insert id="insert" useGeneratedKeys="true"
            keyProperty="id" parameterType="com.fb.bir.pojo.${domain}">
        insert into fb_${table_name}
        <trim prefix="(" suffix=")" suffixOverrides=",">

            <#list columns as col>
                <#if col_has_next>
                    <if test="${col["javaName"]} != null">
                        ${col["name"]},
                    </if>
                <#else>
                    <if test="${col["javaName"]} != null">
                        ${col["name"]}
                    </if>
                </#if>

            </#list>

        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">

        <#list columns as col>
            <#if col_has_next>
            <if test="${col["javaName"]} != null">
                ${r"#{"}${col["name"]},jdbcType=${col["jdbcType"]}},
            </if>
            <#else>
            <if test="${col["javaName"]} != null">
                ${r"#{"}${col["name"]},jdbcType=${col["jdbcType"]}},
            </if>
            </#if>

        </#list>


        </trim>
    </insert>
</mapper>