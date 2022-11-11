package util;

import sun.misc.BASE64Decoder;

import javax.swing.*;
import java.io.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class Base64Util {
//    public static void main(String[] args) throws IOException {
//
//
//        FileReader fileReader = new FileReader(new File("E:\\work\\utils-wbc\\src\\main\\java\\com\\test\\base64\\data"));
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String s = bufferedReader.readLine();
//
//        String relativelyPath = System.getProperty("user.dir");
//        System.out.println(relativelyPath);
//
//        String path = Base64Util.class.getResource("").getPath();
//        System.out.println(path);
//
//        ImageIcon imageIcon = base64FileToImageIcon(new File(PathUtil.getSafePath("data")));
//
//        JOptionPane.showMessageDialog(null, "This is Message area.", "This is title",JOptionPane.INFORMATION_MESSAGE,imageIcon);
//
//
////        GenerateImage("");
//    }

    /**
     *  base64文件 解码 成图片对象
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static ImageIcon base64FileToImageIcon(File file) {
        String imageData = null;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            imageData = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataToImageIcon(imageData);
    }


    /**
     * 字符串 转 java ImageIcon 对象
     * @param imageData
     * @return
     */
    public static ImageIcon dataToImageIcon(String imageData) {
        imageData = init(imageData);
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] bytes = decoder.decodeBuffer(imageData);
            return new ImageIcon(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * base64字符串转化成图片
     *
     * @param imgData
     *            图片编码
     * @param imgFilePath
     *            存放到本地路径
     * @return
     * @throws IOException
     */
    @SuppressWarnings("finally")
    public static boolean GenerateImage(String imgData, String imgFilePath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
        imgData = init(imgData);
        if (imgData == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgData);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return true;
        }
    }

    private static String init(String imgData) {
        String[] split = imgData.split(",");
        imgData = split[split.length-1];
        return imgData;
    }
}
