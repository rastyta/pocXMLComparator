
package com.gw.xmlcompare.model.formschedule;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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

    private final static QName _Type_QNAME = new QName("", "Type");
    private final static QName _Priority_QNAME = new QName("", "Priority");
    private final static QName _IsKey_QNAME = new QName("", "IsKey");
    private final static QName _Minimum_QNAME = new QName("", "Minimum");
    private final static QName _Maximum_QNAME = new QName("", "Maximum");
    private final static QName _ValueRangeGetter_QNAME = new QName("", "ValueRangeGetter");
    private final static QName _ScheduledItemType_QNAME = new QName("", "ScheduledItemType");
    private final static QName _TypeFilter_QNAME = new QName("", "TypeFilter");
    private final static QName _TypeList_QNAME = new QName("", "TypeList");
    private final static QName _ScheduleConfig_QNAME = new QName("", "ScheduleConfig");
    private final static QName _Required_QNAME = new QName("", "Required");
    private final static QName _Default_QNAME = new QName("", "Default");
    private final static QName _MethodExpression_QNAME = new QName("", "MethodExpression");
    private final static QName _PropertyInfo_QNAME = new QName("", "PropertyInfo");
    private final static QName _Version_QNAME = new QName("", "Version");
    private final static QName _AutoNumberPropertyInfo_QNAME = new QName("", "AutoNumberPropertyInfo");
    private final static QName _ColumnName_QNAME = new QName("", "ColumnName");
    private final static QName _ColumnLabel_QNAME = new QName("", "ColumnLabel");
    private final static QName _Clause_QNAME = new QName("", "Clause");
    private final static QName _ItemClause_QNAME = new QName("", "ItemClause");
    private final static QName _OptionGroupLabelMethodExpression_QNAME = new QName("", "OptionGroupLabelMethodExpression");
    private final static QName _OptionLabelMethodExpression_QNAME = new QName("", "OptionLabelMethodExpression");
    private final static QName _Jurisdiction_QNAME = new QName("", "Jurisdiction");
    private final static QName _EffectiveDate_QNAME = new QName("", "EffectiveDate");
    private final static QName _ExpirationDate_QNAME = new QName("", "ExpirationDate");
    private final static QName _Available_QNAME = new QName("", "Available");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ScheduleConfigType }
     * 
     */
    public ScheduleConfigType createScheduleConfigType() {
        return new ScheduleConfigType();
    }

    /**
     * Create an instance of {@link PropertyInfoType }
     * 
     */
    public PropertyInfoType createPropertyInfoType() {
        return new PropertyInfoType();
    }

    /**
     * Create an instance of {@link PropertyInfoVersionType }
     * 
     */
    public PropertyInfoVersionType createPropertyInfoVersionType() {
        return new PropertyInfoVersionType();
    }

    /**
     * Create an instance of {@link AutoNumberPropertyInfoType }
     * 
     */
    public AutoNumberPropertyInfoType createAutoNumberPropertyInfoType() {
        return new AutoNumberPropertyInfoType();
    }

    /**
     * Create an instance of {@link ClauseType }
     * 
     */
    public ClauseType createClauseType() {
        return new ClauseType();
    }

    /**
     * Create an instance of {@link ItemClauseType }
     * 
     */
    public ItemClauseType createItemClauseType() {
        return new ItemClauseType();
    }

    /**
     * Create an instance of {@link BasePropertyInfoType }
     * 
     */
    public BasePropertyInfoType createBasePropertyInfoType() {
        return new BasePropertyInfoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyInfoEnum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PropertyInfoEnum }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Type")
    public JAXBElement<PropertyInfoEnum> createType(PropertyInfoEnum value) {
        return new JAXBElement<PropertyInfoEnum>(_Type_QNAME, PropertyInfoEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Priority")
    public JAXBElement<Integer> createPriority(Integer value) {
        return new JAXBElement<Integer>(_Priority_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "IsKey")
    public JAXBElement<Boolean> createIsKey(Boolean value) {
        return new JAXBElement<Boolean>(_IsKey_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Minimum")
    public JAXBElement<Integer> createMinimum(Integer value) {
        return new JAXBElement<Integer>(_Minimum_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Maximum")
    public JAXBElement<Integer> createMaximum(Integer value) {
        return new JAXBElement<Integer>(_Maximum_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ValueRangeGetter")
    public JAXBElement<String> createValueRangeGetter(String value) {
        return new JAXBElement<String>(_ValueRangeGetter_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ScheduledItemType")
    public JAXBElement<String> createScheduledItemType(String value) {
        return new JAXBElement<String>(_ScheduledItemType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "TypeFilter")
    public JAXBElement<String> createTypeFilter(String value) {
        return new JAXBElement<String>(_TypeFilter_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "TypeList")
    public JAXBElement<String> createTypeList(String value) {
        return new JAXBElement<String>(_TypeList_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleConfigType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ScheduleConfigType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ScheduleConfig")
    public JAXBElement<ScheduleConfigType> createScheduleConfig(ScheduleConfigType value) {
        return new JAXBElement<ScheduleConfigType>(_ScheduleConfig_QNAME, ScheduleConfigType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Required")
    public JAXBElement<Boolean> createRequired(Boolean value) {
        return new JAXBElement<Boolean>(_Required_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Default")
    public JAXBElement<String> createDefault(String value) {
        return new JAXBElement<String>(_Default_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MethodExpression")
    public JAXBElement<String> createMethodExpression(String value) {
        return new JAXBElement<String>(_MethodExpression_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyInfoType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PropertyInfoType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "PropertyInfo")
    public JAXBElement<PropertyInfoType> createPropertyInfo(PropertyInfoType value) {
        return new JAXBElement<PropertyInfoType>(_PropertyInfo_QNAME, PropertyInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyInfoVersionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PropertyInfoVersionType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Version")
    public JAXBElement<PropertyInfoVersionType> createVersion(PropertyInfoVersionType value) {
        return new JAXBElement<PropertyInfoVersionType>(_Version_QNAME, PropertyInfoVersionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutoNumberPropertyInfoType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AutoNumberPropertyInfoType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "AutoNumberPropertyInfo")
    public JAXBElement<AutoNumberPropertyInfoType> createAutoNumberPropertyInfo(AutoNumberPropertyInfoType value) {
        return new JAXBElement<AutoNumberPropertyInfoType>(_AutoNumberPropertyInfo_QNAME, AutoNumberPropertyInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ColumnName")
    public JAXBElement<String> createColumnName(String value) {
        return new JAXBElement<String>(_ColumnName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ColumnLabel")
    public JAXBElement<String> createColumnLabel(String value) {
        return new JAXBElement<String>(_ColumnLabel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClauseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClauseType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Clause")
    public JAXBElement<ClauseType> createClause(ClauseType value) {
        return new JAXBElement<ClauseType>(_Clause_QNAME, ClauseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemClauseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemClauseType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ItemClause")
    public JAXBElement<ItemClauseType> createItemClause(ItemClauseType value) {
        return new JAXBElement<ItemClauseType>(_ItemClause_QNAME, ItemClauseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "OptionGroupLabelMethodExpression")
    public JAXBElement<String> createOptionGroupLabelMethodExpression(String value) {
        return new JAXBElement<String>(_OptionGroupLabelMethodExpression_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "OptionLabelMethodExpression")
    public JAXBElement<String> createOptionLabelMethodExpression(String value) {
        return new JAXBElement<String>(_OptionLabelMethodExpression_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "EffectiveDate")
    public JAXBElement<String> createEffectiveDate(String value) {
        return new JAXBElement<String>(_EffectiveDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ExpirationDate")
    public JAXBElement<String> createExpirationDate(String value) {
        return new JAXBElement<String>(_ExpirationDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Available")
    public JAXBElement<Boolean> createAvailable(Boolean value) {
        return new JAXBElement<Boolean>(_Available_QNAME, Boolean.class, null, value);
    }

}
