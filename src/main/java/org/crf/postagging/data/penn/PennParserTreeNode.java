package org.crf.postagging.data.penn;

import java.util.LinkedList;
import java.util.List;

/**
 * An internally-used Java data-structure to represent a parse-tree node of Penn Tree-Bank.
 * 
 * @author Asher Stern
 * Date: Nov 16, 2014
 *
 */
public class PennParserTreeNode
{
	public PennParserTreeNode(String nodeString)
	{
		super();
		this.nodeString = nodeString;
		this.children = new LinkedList<PennParserTreeNode>();
	}
	
	
	public void addChild(PennParserTreeNode node)
	{
		children.add(node);
	}
	
	public String getNodeString()
	{
		return nodeString;
	}
	public List<PennParserTreeNode> getChildren()
	{
		return children;
	}



	private final String nodeString;
	private final List<PennParserTreeNode> children;
}
