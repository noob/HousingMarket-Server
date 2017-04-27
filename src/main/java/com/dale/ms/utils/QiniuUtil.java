package com.dale.ms.utils;

import java.io.File;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class QiniuUtil {

	static Auth auth = Auth.create(GlobalUtil.ACCESS_KEY, GlobalUtil.SECRET_KEY);

	public static void main(String[] args) {
//		File file = new File("C:/Users/HZF/Desktop/smoke_1.jpg");
//		 try {
//		 upload(file, "123.jpg", token);
//		 } catch (Exception e) {
//		 e.printStackTrace();
//		 }
//		 try {
//		 delete("123.jpg");
//		 } catch (Exception e) {
//		 e.printStackTrace();
//		 }
//		System.out.println(getUpToken());
//		System.out.println(getPrivateUrl("neck-default_image.png"));
		System.out.println(getPrivateUrl("smoke_3.jpg"));
	}

	// 重用 uploadManager。一般地，只需要创建一个 uploadManager 对象
	static UploadManager uploadManager = new UploadManager();
	static BucketManager bucketManager = new BucketManager(auth);
	public static String token = "ulpLOMVJMVYxfNtuECDMo36dm-SbwaYoYYgZYouZ:1nIxkQ_kUteN3KWtk49zHvEq4ZU=:eyJzY29wZSI6ImhoaGgiLCJyZXR1cm5Cb2R5Ijoie1wia2V5XCI6ICQoa2V5KSwgXCJoYXNoXCI6ICQoZXRhZyksIFwid2lkdGhcIjogJChpbWFnZUluZm8ud2lkdGgpLCBcImhlaWdodFwiOiAkKGltYWdlSW5mby5oZWlnaHQpfSIsImRlYWRsaW5lIjoxNzczOTExMDQ5fQ==";

	/**
	 * token 有效时间10年
	 */
	public static String getUpToken() {
		return token;
//		 return auth.uploadToken("hhhh", null, 3600 * 24 * 365 * 10, new StringMap().putNotEmpty("returnBody", "{\"key\": $(key), \"hash\": $(etag), \"width\": $(imageInfo.width), \"height\": $(imageInfo.height)}"));
	}

	/**
	 * 生成私有下载文件链接
	 * @param key
	 * @return
	 */
	public static String getPrivateUrl(String key) {
		return auth.privateDownloadUrl(GlobalUtil.QINIU_PREFIX + key, 3600 * 24 * 365 * 10);
	}
	
	/**
	 * 删除文件
	 */
	public static void delete(String key) throws Exception {
		try {
			bucketManager.delete("hhhh", key);
		} catch (QiniuException e) {
			throw e;
		}
	}

	/**
	 * 上传文件
	 */
	@SuppressWarnings("unused")
	public static void upload(File file, String name, String token) throws Exception {
		try {
			byte[] bytes = FileUtil.file2Bytes(file);
			Response res = uploadManager.put(bytes, name, token);
			DefaultPutRet ret = res.jsonToObject(DefaultPutRet.class);
		} catch (QiniuException e) {
			throw e;
		}
	}

	public class MyRet {
		public long fsize;
		public String key;
		public String hash;
		public int width;
		public int height;
	}
	
	
	
	
}
