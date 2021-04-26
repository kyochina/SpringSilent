/**
     *  复制文件
     * @param sourceFilePath 原文件路径
     * @param targetFilePath 新文件路径
     * @return boolean 如果新文件大小超过0 ，则复制成功
     * @throws IOException
     */
    public static boolean copyFile(String sourceFilePath, String targetFilePath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists()) {
            throw new FileNotFoundException(sourceFilePath);
        }
        File targetFile = new File(targetFilePath);
        FileUtils.touch(targetFile);
        FileUtils.copyFile(sourceFile, targetFile);
        return FileUtils.sizeOf(targetFile) > 0;
    }

    /**
     *  下载网络文件
     * @param urlPath 文件网络路径
     * @param targetFilePath 新文件路径
     * @return boolean 如果新文件大小超过0 ，则复制成功
     * @throws IOException
     */
    public static boolean downloadUrlFile(String urlPath, String targetFilePath) throws IOException {
        URL url = new URL(urlPath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0(compatible;MSIE 5.0;Windows NT;DigExt)");
        Long totalSize = Long.parseLong(conn.getHeaderField("Content-Length"));
        if (totalSize == 0) {
            throw new FileNotFoundException(urlPath);
        }
        File targetFile = new File(targetFilePath);
        FileUtils.touch(targetFile);
        FileUtils.copyURLToFile(url, targetFile);
        return FileUtils.sizeOf(targetFile) > 0;
    }