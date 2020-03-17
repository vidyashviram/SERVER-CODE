package com.mro.drc.administrator.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.mro.drc.administrator.entity.EmailTemplateConfig;

/**
 * @author 40008878
 *Repository to fetch details from EmailTemplateConfig table
 */
public interface EmailTemplateConfigDao extends JpaRepository<EmailTemplateConfig, Integer>{

	/**
	 * @return : Query returns all the records from EmailTemplateConfig table
	 */
	@Query("from EmailTemplateConfig order by templateId desc")
	List<EmailTemplateConfig> getEmailTemplateList();

	/**
	 * @param templateId : query return to fetch record from EmailTemplateConfig tables bases on templateId
	 * @return : EmailTemplateConfig record
	 */
	@Query("from EmailTemplateConfig where templateId = :templateId")
	EmailTemplateConfig getEmailTemplateById(@RequestParam("templateId") Integer templateId);

}
