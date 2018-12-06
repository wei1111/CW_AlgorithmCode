package tree;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/5 15:40
 * @Description: 获得最大的活跃度 树型dp
 * 一个公司的举行晚会一个下级的领导来了，那么他就不来了
 * 如果他的领导没来，他就可能来，也可能不来，每个人都有
 * 自己的活跃度权重，正负都可以
 * 1>当前节点来的活跃度
 * 2>当前节点不来的活跃度
 */
public class GetMaxHuoYueDu {
    class Node {
        int weight;
        Node[] subordinates;
    }

    class ReturnType {
        int buLai;
        int lia;

        public ReturnType(int buLai, int lia) {
            this.buLai = buLai;
            lia = lia;
        }
    }

    public ReturnType getMaxHuoYueDu(Node node) {
        int lai = node.weight;
        int buLai = 0;
        //dfs
        for (int i = 0; i < node.subordinates.length; i++) {
            ReturnType mh = getMaxHuoYueDu(node.subordinates[i]);
            //因为有正负之分，所以不要省了一个
            lai += mh.buLai;
            buLai += Math.max(mh.buLai,mh.lia);
        }
        return new ReturnType(buLai, lai);
    }


}
