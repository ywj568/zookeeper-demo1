package zookeeperdemo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;


public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework=CuratorFrameworkFactory.
                builder().connectString("192.168.18.151:2181," +
                "192.168.18.210:2181,192.168.18.207:2181").
                sessionTimeoutMs(4000).retryPolicy(new
                ExponentialBackoffRetry(1000,3)).
                namespace("").build();
        curatorFramework.start();
        Stat stat=new Stat();
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/ywj");
        System.out.println(new String(bytes));
        curatorFramework.close();
    }
}
