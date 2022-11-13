package util;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class PathUtil {

//    public static void main(String[] args) throws FileNotFoundException {
//
//        System.out.println(PathUtil.isRunInJar());
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(PathUtil.class.getResource("").getPath());
//
//        String path = getRootPath();
//
//
//        path = getResourcePath();
//
//
//        FileReader fileReader = new FileReader(PathUtil.getRootPath()+"/target/classes/static/data");
//        FileReader fileReader1 = new FileReader("/static/data");
//
//        String str = getSafePath("data");
//
//    }

    private static String getResourcePath() {
        return PathUtil.class.getResource("").getPath();
    }


    public static String getSafePath(String path) {

        if(path == null){
            return "";
        }

        boolean b = path.startsWith("/");
        boolean contains = path.contains(":");

        if(!(b||contains)){
            //相对路径
             return PathUtil.getResourcePath()+"../resources/"+path;
        }
        return path;
    }


    /**
     * 获取项目根目录
     * @return
     */
    private static String getRootPath() {
        return System.getProperty("user.dir");
    }

    //判断是从 jar 启动还是本地启动
    private static boolean isRunInJar() {
        String path = PathUtil.class.getResource("PathUtil.class").toString();
        return path.contains("jar:file");
    }
}
