package com.lzp.common.hibernate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

public class HibernateAwareObjectMapper extends ObjectMapper {
	public HibernateAwareObjectMapper() {
		Hibernate4Module hm = new Hibernate4Module();
//		hm.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
//		hm.configure(Feature.REQUIRE_EXPLICIT_LAZY_LOADING_MARKER, true);
		hm.configure(Feature.USE_TRANSIENT_ANNOTATION,false);
//		super.setSerializationInclusion(Include.NON_NULL);
		super.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		super.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		registerModule(hm);
	}

}
