package Util.Xpath;

public class XmlLeafBean {

    private String xpath;

    private String value;

    public XmlLeafBean() {

    }

    /**
     *
     * <DL>
     * <DT><B> 标题 </B></DT>
     * <DD>详细介绍</DD>
     * </DL>
     *
     * @param xpath
     * @param value
     *
     */
    public XmlLeafBean(String xpath, String value) {
        this.xpath = xpath;
        this.value = value;
    }

    /**
     * @return the xpath
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * @param xpath
     *            the xpath to set
     */
    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}
