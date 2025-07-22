
package com.gw.xmlcompare.model.formpatterns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import java.math.BigInteger;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProductCode_QNAME = new QName("", "ProductCode");
    private final static QName _ClausePatternCode_QNAME = new QName("", "ClausePatternCode");
    private final static QName _Code_QNAME = new QName("", "Code");
    private final static QName _CoverableTypeKeyExistsOnAll_QNAME = new QName("", "CoverableTypeKeyExistsOnAll");
    private final static QName _Description_QNAME = new QName("", "Description");
    private final static QName _Edition_QNAME = new QName("", "Edition");
    private final static QName _EndorsementNumbered_QNAME = new QName("", "EndorsementNumbered");
    private final static QName _FormNumber_QNAME = new QName("", "FormNumber");
    private final static QName _JobType_QNAME = new QName("", "JobType");
    private final static QName _PatternExistsOnAll_QNAME = new QName("", "PatternExistsOnAll");
    private final static QName _PolicyLinePatternCode_QNAME = new QName("", "PolicyLinePatternCode");
    private final static QName _Priority_QNAME = new QName("", "Priority");
    private final static QName _UseInsteadOfCode_QNAME = new QName("", "UseInsteadOfCode");
    private final static QName _GenericInferenceClass_QNAME = new QName("", "GenericInferenceClass");
    private final static QName _InferenceTime_QNAME = new QName("", "InferenceTime");
    private final static QName _InternalGroupCode_QNAME = new QName("", "InternalGroupCode");
    private final static QName _InternalReissueOnChange_QNAME = new QName("", "InternalReissueOnChange");
    private final static QName _InternalRemovalEndorsement_QNAME = new QName("", "InternalRemovalEndorsement");
    private final static QName _Availability_QNAME = new QName("", "Availability");
    private final static QName _Jurisdiction_QNAME = new QName("", "Jurisdiction");
    private final static QName _StartEffectiveDate_QNAME = new QName("", "StartEffectiveDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FormPatterns }
     * 
     */
    public FormPatterns createFormPatterns() {
        return new FormPatterns();
    }

    /**
     * Create an instance of {@link FormPattern }
     * 
     */
    public FormPattern createFormPattern() {
        return new FormPattern();
    }

    /**
     * Create an instance of {@link FormPatternProducts }
     * 
     */
    public FormPatternProducts createFormPatternProducts() {
        return new FormPatternProducts();
    }

    /**
     * Create an instance of {@link FormPatternProduct }
     * 
     */
    public FormPatternProduct createFormPatternProduct() {
        return new FormPatternProduct();
    }

    /**
     * Create an instance of {@link CovSysTableValueExistsOnAll }
     * 
     */
    public CovSysTableValueExistsOnAll createCovSysTableValueExistsOnAll() {
        return new CovSysTableValueExistsOnAll();
    }

    /**
     * Create an instance of {@link CoverableSysTable }
     * 
     */
    public CoverableSysTable createCoverableSysTable() {
        return new CoverableSysTable();
    }

    /**
     * Create an instance of {@link CoverableType }
     * 
     */
    public CoverableType createCoverableType() {
        return new CoverableType();
    }

    /**
     * Create an instance of {@link CoverableTypeKey }
     * 
     */
    public CoverableTypeKey createCoverableTypeKey() {
        return new CoverableTypeKey();
    }

    /**
     * Create an instance of {@link CoverableTypeKeys }
     * 
     */
    public CoverableTypeKeys createCoverableTypeKeys() {
        return new CoverableTypeKeys();
    }

    /**
     * Create an instance of {@link CoverableTypeList }
     * 
     */
    public CoverableTypeList createCoverableTypeList() {
        return new CoverableTypeList();
    }

    /**
     * Create an instance of {@link DescriptionL10NARRAY }
     * 
     */
    public DescriptionL10NARRAY createDescriptionL10NARRAY() {
        return new DescriptionL10NARRAY();
    }

    /**
     * Create an instance of {@link FormPatternAdditionalInsuredTypes }
     * 
     */
    public FormPatternAdditionalInsuredTypes createFormPatternAdditionalInsuredTypes() {
        return new FormPatternAdditionalInsuredTypes();
    }

    /**
     * Create an instance of {@link FormPatternAdditionalInterestTypes }
     * 
     */
    public FormPatternAdditionalInterestTypes createFormPatternAdditionalInterestTypes() {
        return new FormPatternAdditionalInterestTypes();
    }

    /**
     * Create an instance of {@link FormPatternClauseCodes }
     * 
     */
    public FormPatternClauseCodes createFormPatternClauseCodes() {
        return new FormPatternClauseCodes();
    }

    /**
     * Create an instance of {@link FormPatternCovTerms }
     * 
     */
    public FormPatternCovTerms createFormPatternCovTerms() {
        return new FormPatternCovTerms();
    }

    /**
     * Create an instance of {@link FormPatternCoverableProperties }
     * 
     */
    public FormPatternCoverableProperties createFormPatternCoverableProperties() {
        return new FormPatternCoverableProperties();
    }

    /**
     * Create an instance of {@link FormPatternCoveragePartTypes }
     * 
     */
    public FormPatternCoveragePartTypes createFormPatternCoveragePartTypes() {
        return new FormPatternCoveragePartTypes();
    }

    /**
     * Create an instance of {@link FormPatternJobs }
     * 
     */
    public FormPatternJobs createFormPatternJobs() {
        return new FormPatternJobs();
    }

    /**
     * Create an instance of {@link FormPatternJob }
     * 
     */
    public FormPatternJob createFormPatternJob() {
        return new FormPatternJob();
    }

    /**
     * Create an instance of {@link RefCode }
     * 
     */
    public RefCode createRefCode() {
        return new RefCode();
    }

    /**
     * Create an instance of {@link RemovalEndorsementFormNumber }
     * 
     */
    public RemovalEndorsementFormNumber createRemovalEndorsementFormNumber() {
        return new RemovalEndorsementFormNumber();
    }

    /**
     * Create an instance of {@link Lookups }
     * 
     */
    public Lookups createLookups() {
        return new Lookups();
    }

    /**
     * Create an instance of {@link FormPatternLookup }
     * 
     */
    public FormPatternLookup createFormPatternLookup() {
        return new FormPatternLookup();
    }

    /**
     * Create an instance of {@link EndEffectiveDate }
     * 
     */
    public EndEffectiveDate createEndEffectiveDate() {
        return new EndEffectiveDate();
    }

    /**
     * Create an instance of {@link UWCompanyCode }
     * 
     */
    public UWCompanyCode createUWCompanyCode() {
        return new UWCompanyCode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ProductCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createProductCode(String value) {
        return new JAXBElement<String>(_ProductCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ClausePatternCode")
    public JAXBElement<String> createClausePatternCode(String value) {
        return new JAXBElement<String>(_ClausePatternCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "CoverableTypeKeyExistsOnAll")
    public JAXBElement<String> createCoverableTypeKeyExistsOnAll(String value) {
        return new JAXBElement<String>(_CoverableTypeKeyExistsOnAll_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Edition")
    public JAXBElement<String> createEdition(String value) {
        return new JAXBElement<String>(_Edition_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "EndorsementNumbered")
    public JAXBElement<Boolean> createEndorsementNumbered(Boolean value) {
        return new JAXBElement<Boolean>(_EndorsementNumbered_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FormNumber")
    public JAXBElement<String> createFormNumber(String value) {
        return new JAXBElement<String>(_FormNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "JobType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createJobType(String value) {
        return new JAXBElement<String>(_JobType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "PatternExistsOnAll")
    public JAXBElement<Boolean> createPatternExistsOnAll(Boolean value) {
        return new JAXBElement<Boolean>(_PatternExistsOnAll_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "PolicyLinePatternCode")
    public JAXBElement<String> createPolicyLinePatternCode(String value) {
        return new JAXBElement<String>(_PolicyLinePatternCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Priority")
    public JAXBElement<BigInteger> createPriority(BigInteger value) {
        return new JAXBElement<BigInteger>(_Priority_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "UseInsteadOfCode")
    public JAXBElement<String> createUseInsteadOfCode(String value) {
        return new JAXBElement<String>(_UseInsteadOfCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "GenericInferenceClass")
    public JAXBElement<String> createGenericInferenceClass(String value) {
        return new JAXBElement<String>(_GenericInferenceClass_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "InferenceTime")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createInferenceTime(String value) {
        return new JAXBElement<String>(_InferenceTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "InternalGroupCode")
    public JAXBElement<String> createInternalGroupCode(String value) {
        return new JAXBElement<String>(_InternalGroupCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "InternalReissueOnChange")
    public JAXBElement<Boolean> createInternalReissueOnChange(Boolean value) {
        return new JAXBElement<Boolean>(_InternalReissueOnChange_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "InternalRemovalEndorsement")
    public JAXBElement<Boolean> createInternalRemovalEndorsement(Boolean value) {
        return new JAXBElement<Boolean>(_InternalRemovalEndorsement_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Availability")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createAvailability(String value) {
        return new JAXBElement<String>(_Availability_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Jurisdiction")
    public JAXBElement<String> createJurisdiction(String value) {
        return new JAXBElement<String>(_Jurisdiction_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "StartEffectiveDate")
    public JAXBElement<String> createStartEffectiveDate(String value) {
        return new JAXBElement<String>(_StartEffectiveDate_QNAME, String.class, null, value);
    }

}
