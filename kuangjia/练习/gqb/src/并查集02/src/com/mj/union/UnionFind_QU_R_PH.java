package 并查集02.src.com.mj.union;

/**
 * Quick Union - 基于rank的优化 - 路径减半(Path Halving)
 * @author MJ Lee
 *	使路径上每隔一个节点就指向其祖父节点(parent的parent)
 */
public class UnionFind_QU_R_PH extends UnionFind_QU_R {

	public UnionFind_QU_R_PH(int capacity) {
		super(capacity);
	}
	
	@Override
	public int find(int v) { 
		rangeCheck(v);
		while (v != parents[v]) {
			parents[v] = parents[parents[v]];
			v = parents[v];
		}
		return v;
	}
}

