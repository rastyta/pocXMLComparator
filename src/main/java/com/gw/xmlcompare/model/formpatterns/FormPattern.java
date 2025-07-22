
package com.gw.xmlcompare.model.formpatterns;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigInteger;
import java.util.Objects;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;choice minOccurs="0"&amp;gt;
 *         &amp;lt;element ref="{}FormPatternProducts"/&amp;gt;
 *         &amp;lt;sequence&amp;gt;
 *           &amp;lt;element ref="{}ClausePatternCode"/&amp;gt;
 *           &amp;lt;element ref="{}Code"/&amp;gt;
 *           &amp;lt;element ref="{}CovSysTableValueExistsOnAll"/&amp;gt;
 *           &amp;lt;element ref="{}CoverableSysTable"/&amp;gt;
 *           &amp;lt;element ref="{}CoverableType"/&amp;gt;
 *           &amp;lt;element ref="{}CoverableTypeKey"/&amp;gt;
 *           &amp;lt;element ref="{}CoverableTypeKeyExistsOnAll"/&amp;gt;
 *           &amp;lt;element ref="{}CoverableTypeKeys"/&amp;gt;
 *           &amp;lt;element ref="{}CoverableTypeList"/&amp;gt;
 *           &amp;lt;element ref="{}Description"/&amp;gt;
 *           &amp;lt;element ref="{}Description_L10N_ARRAY"/&amp;gt;
 *           &amp;lt;element ref="{}Edition"/&amp;gt;
 *           &amp;lt;element ref="{}EndorsementNumbered"/&amp;gt;
 *           &amp;lt;element ref="{}FormNumber"/&amp;gt;
 *           &amp;lt;element ref="{}FormPatternAdditionalInsuredTypes"/&amp;gt;
 *           &amp;lt;element ref="{}FormPatternAdditionalInterestTypes"/&amp;gt;
 *           &amp;lt;element ref="{}FormPatternClauseCodes"/&amp;gt;
 *           &amp;lt;element ref="{}FormPatternCovTerms"/&amp;gt;
 *           &amp;lt;element ref="{}FormPatternCoverableProperties"/&amp;gt;
 *           &amp;lt;element ref="{}FormPatternCoveragePartTypes"/&amp;gt;
 *           &amp;lt;element ref="{}FormPatternJobs"/&amp;gt;
 *         &amp;lt;/sequence&amp;gt;
 *         &amp;lt;sequence&amp;gt;
 *           &amp;lt;element ref="{}PatternExistsOnAll"/&amp;gt;
 *           &amp;lt;element ref="{}PolicyLinePatternCode"/&amp;gt;
 *           &amp;lt;element ref="{}Priority"/&amp;gt;
 *           &amp;lt;element ref="{}RefCode"/&amp;gt;
 *           &amp;lt;element ref="{}RemovalEndorsementFormNumber"/&amp;gt;
 *           &amp;lt;element ref="{}UseInsteadOfCode"/&amp;gt;
 *         &amp;lt;/sequence&amp;gt;
 *         &amp;lt;sequence&amp;gt;
 *           &amp;lt;element ref="{}GenericInferenceClass"/&amp;gt;
 *           &amp;lt;element ref="{}InferenceTime"/&amp;gt;
 *           &amp;lt;element ref="{}InternalGroupCode"/&amp;gt;
 *           &amp;lt;element ref="{}InternalReissueOnChange"/&amp;gt;
 *           &amp;lt;element ref="{}InternalRemovalEndorsement"/&amp;gt;
 *           &amp;lt;element ref="{}Lookups"/&amp;gt;
 *         &amp;lt;/sequence&amp;gt;
 *       &amp;lt;/choice&amp;gt;
 *       &amp;lt;attribute name="public-id" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "formPatternProducts",
    "clausePatternCode",
    "code",
    "covSysTableValueExistsOnAll",
    "coverableSysTable",
    "coverableType",
    "coverableTypeKey",
    "coverableTypeKeyExistsOnAll",
    "coverableTypeKeys",
    "coverableTypeList",
    "description",
    "descriptionL10NARRAY",
    "edition",
    "endorsementNumbered",
    "formNumber",
    "formPatternAdditionalInsuredTypes",
    "formPatternAdditionalInterestTypes",
    "formPatternClauseCodes",
    "formPatternCovTerms",
    "formPatternCoverableProperties",
    "formPatternCoveragePartTypes",
    "formPatternJobs",
    "patternExistsOnAll",
    "policyLinePatternCode",
    "priority",
    "refCode",
    "removalEndorsementFormNumber",
    "useInsteadOfCode",
    "genericInferenceClass",
    "inferenceTime",
    "internalGroupCode",
    "internalReissueOnChange",
    "internalRemovalEndorsement",
    "lookups"
})
@XmlRootElement(name = "FormPattern")
public class FormPattern {

    @XmlElement(name = "FormPatternProducts")
    protected FormPatternProducts formPatternProducts;
    @XmlElement(name = "ClausePatternCode")
    protected String clausePatternCode;
    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "CovSysTableValueExistsOnAll")
    protected CovSysTableValueExistsOnAll covSysTableValueExistsOnAll;
    @XmlElement(name = "CoverableSysTable")
    protected CoverableSysTable coverableSysTable;
    @XmlElement(name = "CoverableType")
    protected CoverableType coverableType;
    @XmlElement(name = "CoverableTypeKey")
    protected CoverableTypeKey coverableTypeKey;
    @XmlElement(name = "CoverableTypeKeyExistsOnAll")
    protected String coverableTypeKeyExistsOnAll;
    @XmlElement(name = "CoverableTypeKeys")
    protected CoverableTypeKeys coverableTypeKeys;
    @XmlElement(name = "CoverableTypeList")
    protected CoverableTypeList coverableTypeList;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Description_L10N_ARRAY")
    protected DescriptionL10NARRAY descriptionL10NARRAY;
    @XmlElement(name = "Edition")
    protected String edition;
    @XmlElement(name = "EndorsementNumbered")
    protected Boolean endorsementNumbered;
    @XmlElement(name = "FormNumber")
    protected String formNumber;
    @XmlElement(name = "FormPatternAdditionalInsuredTypes")
    protected FormPatternAdditionalInsuredTypes formPatternAdditionalInsuredTypes;
    @XmlElement(name = "FormPatternAdditionalInterestTypes")
    protected FormPatternAdditionalInterestTypes formPatternAdditionalInterestTypes;
    @XmlElement(name = "FormPatternClauseCodes")
    protected FormPatternClauseCodes formPatternClauseCodes;
    @XmlElement(name = "FormPatternCovTerms")
    protected FormPatternCovTerms formPatternCovTerms;
    @XmlElement(name = "FormPatternCoverableProperties")
    protected FormPatternCoverableProperties formPatternCoverableProperties;
    @XmlElement(name = "FormPatternCoveragePartTypes")
    protected FormPatternCoveragePartTypes formPatternCoveragePartTypes;
    @XmlElement(name = "FormPatternJobs")
    protected FormPatternJobs formPatternJobs;
    @XmlElement(name = "PatternExistsOnAll")
    protected Boolean patternExistsOnAll;
    @XmlElement(name = "PolicyLinePatternCode")
    protected String policyLinePatternCode;
    @XmlElement(name = "Priority")
    protected BigInteger priority;
    @XmlElement(name = "RefCode")
    protected RefCode refCode;
    @XmlElement(name = "RemovalEndorsementFormNumber")
    protected RemovalEndorsementFormNumber removalEndorsementFormNumber;
    @XmlElement(name = "UseInsteadOfCode")
    protected String useInsteadOfCode;
    @XmlElement(name = "GenericInferenceClass")
    protected String genericInferenceClass;
    @XmlElement(name = "InferenceTime")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String inferenceTime;
    @XmlElement(name = "InternalGroupCode")
    protected String internalGroupCode;
    @XmlElement(name = "InternalReissueOnChange")
    protected Boolean internalReissueOnChange;
    @XmlElement(name = "InternalRemovalEndorsement")
    protected Boolean internalRemovalEndorsement;
    @XmlElement(name = "Lookups")
    protected Lookups lookups;
    @XmlAttribute(name = "public-id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String publicId;

    /**
     * Gets the value of the formPatternProducts property.
     * 
     * @return
     *     possible object is
     *     {@link FormPatternProducts }
     *     
     */
    public FormPatternProducts getFormPatternProducts() {
        return formPatternProducts;
    }

    /**
     * Sets the value of the formPatternProducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormPatternProducts }
     *     
     */
    public void setFormPatternProducts(FormPatternProducts value) {
        this.formPatternProducts = value;
    }

    /**
     * Gets the value of the clausePatternCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClausePatternCode() {
        return clausePatternCode;
    }

    /**
     * Sets the value of the clausePatternCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClausePatternCode(String value) {
        this.clausePatternCode = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the covSysTableValueExistsOnAll property.
     * 
     * @return
     *     possible object is
     *     {@link CovSysTableValueExistsOnAll }
     *     
     */
    public CovSysTableValueExistsOnAll getCovSysTableValueExistsOnAll() {
        return covSysTableValueExistsOnAll;
    }

    /**
     * Sets the value of the covSysTableValueExistsOnAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link CovSysTableValueExistsOnAll }
     *     
     */
    public void setCovSysTableValueExistsOnAll(CovSysTableValueExistsOnAll value) {
        this.covSysTableValueExistsOnAll = value;
    }

    /**
     * Gets the value of the coverableSysTable property.
     * 
     * @return
     *     possible object is
     *     {@link CoverableSysTable }
     *     
     */
    public CoverableSysTable getCoverableSysTable() {
        return coverableSysTable;
    }

    /**
     * Sets the value of the coverableSysTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverableSysTable }
     *     
     */
    public void setCoverableSysTable(CoverableSysTable value) {
        this.coverableSysTable = value;
    }

    /**
     * Gets the value of the coverableType property.
     * 
     * @return
     *     possible object is
     *     {@link CoverableType }
     *     
     */
    public CoverableType getCoverableType() {
        return coverableType;
    }

    /**
     * Sets the value of the coverableType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverableType }
     *     
     */
    public void setCoverableType(CoverableType value) {
        this.coverableType = value;
    }

    /**
     * Gets the value of the coverableTypeKey property.
     * 
     * @return
     *     possible object is
     *     {@link CoverableTypeKey }
     *     
     */
    public CoverableTypeKey getCoverableTypeKey() {
        return coverableTypeKey;
    }

    /**
     * Sets the value of the coverableTypeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverableTypeKey }
     *     
     */
    public void setCoverableTypeKey(CoverableTypeKey value) {
        this.coverableTypeKey = value;
    }

    /**
     * Gets the value of the coverableTypeKeyExistsOnAll property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverableTypeKeyExistsOnAll() {
        return coverableTypeKeyExistsOnAll;
    }

    /**
     * Sets the value of the coverableTypeKeyExistsOnAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverableTypeKeyExistsOnAll(String value) {
        this.coverableTypeKeyExistsOnAll = value;
    }

    /**
     * Gets the value of the coverableTypeKeys property.
     * 
     * @return
     *     possible object is
     *     {@link CoverableTypeKeys }
     *     
     */
    public CoverableTypeKeys getCoverableTypeKeys() {
        return coverableTypeKeys;
    }

    /**
     * Sets the value of the coverableTypeKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverableTypeKeys }
     *     
     */
    public void setCoverableTypeKeys(CoverableTypeKeys value) {
        this.coverableTypeKeys = value;
    }

    /**
     * Gets the value of the coverableTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link CoverableTypeList }
     *     
     */
    public CoverableTypeList getCoverableTypeList() {
        return coverableTypeList;
    }

    /**
     * Sets the value of the coverableTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverableTypeList }
     *     
     */
    public void setCoverableTypeList(CoverableTypeList value) {
        this.coverableTypeList = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the descriptionL10NARRAY property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionL10NARRAY }
     *     
     */
    public DescriptionL10NARRAY getDescriptionL10NARRAY() {
        return descriptionL10NARRAY;
    }

    /**
     * Sets the value of the descriptionL10NARRAY property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionL10NARRAY }
     *     
     */
    public void setDescriptionL10NARRAY(DescriptionL10NARRAY value) {
        this.descriptionL10NARRAY = value;
    }

    /**
     * Gets the value of the edition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdition() {
        return edition;
    }

    /**
     * Sets the value of the edition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdition(String value) {
        this.edition = value;
    }

    /**
     * Gets the value of the endorsementNumbered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEndorsementNumbered() {
        return endorsementNumbered;
    }

    /**
     * Sets the value of the endorsementNumbered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEndorsementNumbered(Boolean value) {
        this.endorsementNumbered = value;
    }

    /**
     * Gets the value of the formNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormNumber() {
        return formNumber;
    }

    /**
     * Sets the value of the formNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormNumber(String value) {
        this.formNumber = value;
    }

    /**
     * Gets the value of the formPatternAdditionalInsuredTypes property.
     * 
     * @return
     *     possible object is
     *     {@link FormPatternAdditionalInsuredTypes }
     *     
     */
    public FormPatternAdditionalInsuredTypes getFormPatternAdditionalInsuredTypes() {
        return formPatternAdditionalInsuredTypes;
    }

    /**
     * Sets the value of the formPatternAdditionalInsuredTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormPatternAdditionalInsuredTypes }
     *     
     */
    public void setFormPatternAdditionalInsuredTypes(FormPatternAdditionalInsuredTypes value) {
        this.formPatternAdditionalInsuredTypes = value;
    }

    /**
     * Gets the value of the formPatternAdditionalInterestTypes property.
     * 
     * @return
     *     possible object is
     *     {@link FormPatternAdditionalInterestTypes }
     *     
     */
    public FormPatternAdditionalInterestTypes getFormPatternAdditionalInterestTypes() {
        return formPatternAdditionalInterestTypes;
    }

    /**
     * Sets the value of the formPatternAdditionalInterestTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormPatternAdditionalInterestTypes }
     *     
     */
    public void setFormPatternAdditionalInterestTypes(FormPatternAdditionalInterestTypes value) {
        this.formPatternAdditionalInterestTypes = value;
    }

    /**
     * Gets the value of the formPatternClauseCodes property.
     * 
     * @return
     *     possible object is
     *     {@link FormPatternClauseCodes }
     *     
     */
    public FormPatternClauseCodes getFormPatternClauseCodes() {
        return formPatternClauseCodes;
    }

    /**
     * Sets the value of the formPatternClauseCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormPatternClauseCodes }
     *     
     */
    public void setFormPatternClauseCodes(FormPatternClauseCodes value) {
        this.formPatternClauseCodes = value;
    }

    /**
     * Gets the value of the formPatternCovTerms property.
     * 
     * @return
     *     possible object is
     *     {@link FormPatternCovTerms }
     *     
     */
    public FormPatternCovTerms getFormPatternCovTerms() {
        return formPatternCovTerms;
    }

    /**
     * Sets the value of the formPatternCovTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormPatternCovTerms }
     *     
     */
    public void setFormPatternCovTerms(FormPatternCovTerms value) {
        this.formPatternCovTerms = value;
    }

    /**
     * Gets the value of the formPatternCoverableProperties property.
     * 
     * @return
     *     possible object is
     *     {@link FormPatternCoverableProperties }
     *     
     */
    public FormPatternCoverableProperties getFormPatternCoverableProperties() {
        return formPatternCoverableProperties;
    }

    /**
     * Sets the value of the formPatternCoverableProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormPatternCoverableProperties }
     *     
     */
    public void setFormPatternCoverableProperties(FormPatternCoverableProperties value) {
        this.formPatternCoverableProperties = value;
    }

    /**
     * Gets the value of the formPatternCoveragePartTypes property.
     * 
     * @return
     *     possible object is
     *     {@link FormPatternCoveragePartTypes }
     *     
     */
    public FormPatternCoveragePartTypes getFormPatternCoveragePartTypes() {
        return formPatternCoveragePartTypes;
    }

    /**
     * Sets the value of the formPatternCoveragePartTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormPatternCoveragePartTypes }
     *     
     */
    public void setFormPatternCoveragePartTypes(FormPatternCoveragePartTypes value) {
        this.formPatternCoveragePartTypes = value;
    }

    /**
     * Gets the value of the formPatternJobs property.
     * 
     * @return
     *     possible object is
     *     {@link FormPatternJobs }
     *     
     */
    public FormPatternJobs getFormPatternJobs() {
        return formPatternJobs;
    }

    /**
     * Sets the value of the formPatternJobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormPatternJobs }
     *     
     */
    public void setFormPatternJobs(FormPatternJobs value) {
        this.formPatternJobs = value;
    }

    /**
     * Gets the value of the patternExistsOnAll property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPatternExistsOnAll() {
        return patternExistsOnAll;
    }

    /**
     * Sets the value of the patternExistsOnAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPatternExistsOnAll(Boolean value) {
        this.patternExistsOnAll = value;
    }

    /**
     * Gets the value of the policyLinePatternCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyLinePatternCode() {
        return policyLinePatternCode;
    }

    /**
     * Sets the value of the policyLinePatternCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyLinePatternCode(String value) {
        this.policyLinePatternCode = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPriority(BigInteger value) {
        this.priority = value;
    }

    /**
     * Gets the value of the refCode property.
     * 
     * @return
     *     possible object is
     *     {@link RefCode }
     *     
     */
    public RefCode getRefCode() {
        return refCode;
    }

    /**
     * Sets the value of the refCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefCode }
     *     
     */
    public void setRefCode(RefCode value) {
        this.refCode = value;
    }

    /**
     * Gets the value of the removalEndorsementFormNumber property.
     * 
     * @return
     *     possible object is
     *     {@link RemovalEndorsementFormNumber }
     *     
     */
    public RemovalEndorsementFormNumber getRemovalEndorsementFormNumber() {
        return removalEndorsementFormNumber;
    }

    /**
     * Sets the value of the removalEndorsementFormNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemovalEndorsementFormNumber }
     *     
     */
    public void setRemovalEndorsementFormNumber(RemovalEndorsementFormNumber value) {
        this.removalEndorsementFormNumber = value;
    }

    /**
     * Gets the value of the useInsteadOfCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseInsteadOfCode() {
        return useInsteadOfCode;
    }

    /**
     * Sets the value of the useInsteadOfCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseInsteadOfCode(String value) {
        this.useInsteadOfCode = value;
    }

    /**
     * Gets the value of the genericInferenceClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericInferenceClass() {
        return genericInferenceClass;
    }

    /**
     * Sets the value of the genericInferenceClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericInferenceClass(String value) {
        this.genericInferenceClass = value;
    }

    /**
     * Gets the value of the inferenceTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInferenceTime() {
        return inferenceTime;
    }

    /**
     * Sets the value of the inferenceTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInferenceTime(String value) {
        this.inferenceTime = value;
    }

    /**
     * Gets the value of the internalGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalGroupCode() {
        return internalGroupCode;
    }

    /**
     * Sets the value of the internalGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalGroupCode(String value) {
        this.internalGroupCode = value;
    }

    /**
     * Gets the value of the internalReissueOnChange property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInternalReissueOnChange() {
        return internalReissueOnChange;
    }

    /**
     * Sets the value of the internalReissueOnChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInternalReissueOnChange(Boolean value) {
        this.internalReissueOnChange = value;
    }

    /**
     * Gets the value of the internalRemovalEndorsement property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInternalRemovalEndorsement() {
        return internalRemovalEndorsement;
    }

    /**
     * Sets the value of the internalRemovalEndorsement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInternalRemovalEndorsement(Boolean value) {
        this.internalRemovalEndorsement = value;
    }

    /**
     * Gets the value of the lookups property.
     * 
     * @return
     *     possible object is
     *     {@link Lookups }
     *     
     */
    public Lookups getLookups() {
        return lookups;
    }

    /**
     * Sets the value of the lookups property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lookups }
     *     
     */
    public void setLookups(Lookups value) {
        this.lookups = value;
    }

    /**
     * Gets the value of the publicId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * Sets the value of the publicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicId(String value) {
        this.publicId = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FormPattern that = (FormPattern) o;
        return Objects.equals(formPatternProducts, that.formPatternProducts) && Objects.equals(clausePatternCode, that.clausePatternCode) && Objects.equals(code, that.code) && Objects.equals(covSysTableValueExistsOnAll, that.covSysTableValueExistsOnAll) && Objects.equals(coverableSysTable, that.coverableSysTable) && Objects.equals(coverableType, that.coverableType) && Objects.equals(coverableTypeKey, that.coverableTypeKey) && Objects.equals(coverableTypeKeyExistsOnAll, that.coverableTypeKeyExistsOnAll) && Objects.equals(coverableTypeKeys, that.coverableTypeKeys) && Objects.equals(coverableTypeList, that.coverableTypeList) && Objects.equals(description, that.description) && Objects.equals(descriptionL10NARRAY, that.descriptionL10NARRAY) && Objects.equals(edition, that.edition) && Objects.equals(endorsementNumbered, that.endorsementNumbered) && Objects.equals(formNumber, that.formNumber) && Objects.equals(formPatternAdditionalInsuredTypes, that.formPatternAdditionalInsuredTypes) && Objects.equals(formPatternAdditionalInterestTypes, that.formPatternAdditionalInterestTypes) && Objects.equals(formPatternClauseCodes, that.formPatternClauseCodes) && Objects.equals(formPatternCovTerms, that.formPatternCovTerms) && Objects.equals(formPatternCoverableProperties, that.formPatternCoverableProperties) && Objects.equals(formPatternCoveragePartTypes, that.formPatternCoveragePartTypes) && Objects.equals(formPatternJobs, that.formPatternJobs) && Objects.equals(patternExistsOnAll, that.patternExistsOnAll) && Objects.equals(policyLinePatternCode, that.policyLinePatternCode) && Objects.equals(priority, that.priority) && Objects.equals(refCode, that.refCode) && Objects.equals(removalEndorsementFormNumber, that.removalEndorsementFormNumber) && Objects.equals(useInsteadOfCode, that.useInsteadOfCode) && Objects.equals(genericInferenceClass, that.genericInferenceClass) && Objects.equals(inferenceTime, that.inferenceTime) && Objects.equals(internalGroupCode, that.internalGroupCode) && Objects.equals(internalReissueOnChange, that.internalReissueOnChange) && Objects.equals(internalRemovalEndorsement, that.internalRemovalEndorsement) && Objects.equals(lookups, that.lookups) && Objects.equals(publicId, that.publicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formPatternProducts, clausePatternCode, code, covSysTableValueExistsOnAll, coverableSysTable, coverableType, coverableTypeKey, coverableTypeKeyExistsOnAll, coverableTypeKeys, coverableTypeList, description, descriptionL10NARRAY, edition, endorsementNumbered, formNumber, formPatternAdditionalInsuredTypes, formPatternAdditionalInterestTypes, formPatternClauseCodes, formPatternCovTerms, formPatternCoverableProperties, formPatternCoveragePartTypes, formPatternJobs, patternExistsOnAll, policyLinePatternCode, priority, refCode, removalEndorsementFormNumber, useInsteadOfCode, genericInferenceClass, inferenceTime, internalGroupCode, internalReissueOnChange, internalRemovalEndorsement, lookups, publicId);
    }
}
