/**
 *
 */
package gov.pnnl.prosser.api.pwr.obj;

import gov.pnnl.prosser.api.GldUtils;

/**
 * House Object
 *
 * @author nord229
 */
public class House extends ResidentialEnduse {

    private Node parent;

    private ZIPLoad load;

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @param parent
     *            the parent to set
     */
    public void setParent(final Node parent) {
        this.parent = parent;
    }

    /**
     * @return the load
     */
    public ZIPLoad getLoad() {
        return load;
    }

    /**
     * @param load
     *            the load to set
     */
    public void setLoad(final ZIPLoad load) {
        this.load = load;
    }

    @Override
    public String getGldObjectType() {
        return "house";
    }

    @Override
    protected void writeGldProperties(final StringBuilder sb) {
        GldUtils.writeProperty(sb, "parent", this.parent);
        load.writeGldString(sb);
        // Handle special case since we need a semicolon here
        sb.insert(sb.length() - 1, ';');
    }

}
