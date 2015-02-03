/**
 * 
 */
package gov.pnnl.prosser.api.ns3.obj;

import gov.pnnl.prosser.api.AbstractNs3Object;

/**
 * @author happ546
 *
 */
public class WifiHelper extends AbstractNs3Object {
	
	private String remoteStationManager;

	/**
	 * Sets the default parameters for this WifiHelper (see ns-3 documentation for information)
	 */
	public void defaultParams() {
		appendPrintObj(this.getName() + " = WifiHelper::Default();\n");
	}

	/**
	 * Sets the algorithm used by ns-3 to control the data rate on this WiFi network
	 * @param remoteStationManager
	 */
	public void setRemoteStationManager(String remoteStationManager) {
		this.remoteStationManager = remoteStationManager;
		appendPrintObj(this.getName() + "SetRemoteStationManager(\"" + this.remoteStationManager + "\");\n");
	}

	/**
	 * 
	 * @param phy the physical WiFi helper
	 * @param mac the MAC address WiFi helper
	 * @param wifiStaNodes the NodeContainer containing the Nodes on which to install
	 * 			the WiFi devices
	 * @param destinationContainer the NetDeviceContainer which will hold the installed 
	 * 			WiFi devices
	 */
	public void install(YansWifiPhyHelper phy, NqosWifiMacHelper mac,
			NodeContainer wifiStaNodes, NetDeviceContainer destinationContainer) {
		appendPrintObj(destinationContainer.getName() + " = " + this.getName() + 
				".Install(" + phy.getName() + ", " + mac.getName() + ", " + wifiStaNodes.getName() + ");\n");
		
	}
	
}