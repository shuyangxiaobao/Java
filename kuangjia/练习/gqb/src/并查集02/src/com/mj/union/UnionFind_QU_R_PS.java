package 并查集02.src.com.mj.union;

/**
 * Quick Union - 基于rank的优化 - 路径分裂(Path Spliting)
 * @author MJ Lee
 *  使路径上的每个节点都指向其祖父节点(parent的parent)
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R {

	public UnionFind_QU_R_PS(int capacity) {
		super(capacity);
	}
	
	@Override
	public int find(int v) { 
		rangeCheck(v);
		while (v != parents[v]) {
			int parent = parents[v];
			parents[v] = parents[parent];
			v = parent;
		}
		return v;
	}
}