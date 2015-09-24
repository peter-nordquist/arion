/**
 * 
 */
package gov.pnnl.prosser.api.ns3.obj.p2p;

import gov.pnnl.prosser.api.ns3.obj.NetDeviceContainer;
import gov.pnnl.prosser.api.ns3.obj.NetworkHelper;
import gov.pnnl.prosser.api.ns3.obj.Node;
import gov.pnnl.prosser.api.ns3.obj.NodeContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * The PointToPointHelper simplifies the setup of point-to-point (p2p) networks.
 * 
 * @author happ546
 *
 */
public class PointToPointHelper extends NetworkHelper {
	private Map<String, String> channelAttributes;
	private Map<String, String> deviceAttributes;
	
	/**
	 * Construct a new point to point helper to handle creation of a p2p node/channel
	 * 
	 * @param name
	 */
	public PointToPointHelper(String name) {
		this.setName(name);
		this.channelAttributes = new HashMap<>();
		this.deviceAttributes = new HashMap<>();
	}

	/**
	 * @param nodeA 
	 * @param nodeB 
	 * @param channel 
	 * @param p2pDevices
	 */
	public void install(Node nodeA, Node nodeB,
			PointToPointChannel channel, NetDeviceContainer p2pDevices) {
		
		if (channel != null) {
			this.setChannelAttribute("Delay", channel.getDelay());
			this.setDeviceAttribute("DataRate", channel.getDataRate());
		}
		
		appendPrintInfo(p2pDevices.getName() + ".Add (" + this.getName() +
				".Install (" + nodeA.getName() + ", " +
				nodeB.getName() + "));\n");
	}
	
	/**
	 * @param nodeA
	 * @param nodeB
	 * @param p2pDevices
	 */
	public void install(Node nodeA, Node nodeB, NetDeviceContainer p2pDevices) {
		install(nodeA, nodeB, null, p2pDevices);
	}

	/**
	 * Installs p2p NetDevices on the nodes in the given NodeContainer
	 * 
	 * @param nodes
	 */
	public void install(NodeContainer nodes) {
		appendPrintInfo(this.getName() + ".Install (" + nodes.getName() + ");\n");
	}
	


	/**
	 * Sets attributes for this point to point channel
	 * 
	 * @param attr the attribute to set the value to
	 * @param value
	 */
	public void setChannelAttribute(String attr, String value) {
		channelAttributes.put(attr, value);
		appendPrintInfo(this.getName() + ".SetChannelAttribute (\"" + attr
				+ "\", StringValue (\"" + value + "\"));\n");
	}
	
	/**
	 * Sets attributes for this point to point device
	 * 
	 * @param attr the attribute to set the value to
	 * @param value the string value (e.g. DataRate)
	 */
	public void setDeviceAttribute(String attr, String value) {
		deviceAttributes.put(attr, value);
		String valueWrapperPrefix = "StringValue (\"";
		String valueWrapperSuffix = "\")";
		if (attr.equals("DataRate")) {
			valueWrapperPrefix = "DataRateValue (DataRate (\"";
			valueWrapperSuffix = "\"))";
		}
		appendPrintInfo(this.getName() + ".SetDeviceAttribute (\"" + attr + "\", "
				+ valueWrapperPrefix + value + valueWrapperSuffix + ");\n");
	}

	/**
	 * @param attr the attribute to set the value to
	 * @param value the integer value (e.g. MTU value)
	 */
	public void setDeviceAttribute(String attr, int value) {
		deviceAttributes.put(attr, "" + value);
		appendPrintInfo(this.getName() + ".SetDeviceAttribute (\"" + attr
				+ "\", UintegerValue (" + value + "));\n");
	}

}