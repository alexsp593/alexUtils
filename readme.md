# 加密类(encrypt)
## ASE加密(ASEUtil)
    static String encrypt(String secretKey, String Str)
    加密字符串
    static String decode(String secretKey, String str)
    解密字符串

## Base32的编码和解码(Base32)
    static String encode(final byte[] bytes)
    使用Base32进行编码
    static String decode(final String base32)
    用Base32进行解码

## Base64的编码和解码(Base64)
    static char[] encodeToChar(byte[] arr, boolean lineSeparator)
    将原始字节数组编码为Base64字符数组
    static byte[] encodeToByte(String s)
    将字符串编码成Base64字节数组
    static byte[] encodeToByte(String s, boolean lineSep)
    将字符串编码成Base64字节数组,可选的CRLF后76字符，除非EOF
    static byte[] encodeToByte(byte[] arr)
    将原始字节数组编码为Base64字节数组
    static byte[] encodeToByte(byte[] arr, boolean lineSep)
    将原始字节数组编码为Base64字节数组,可选的CRLF后76字符，除非EOF
    static String decodeToString(byte[] arr)
    将字节数组Base64解密为字符串
    static byte[] decode(byte[] arr)
    解码Base64编码的字节数组
    static String encodeToString(String s)
    将字符串Base64编码为字符串
    static String encodeToString(String s, boolean lineSep)
    将字符串Base64编码为字符串,可选的CRLF后76字符，除非EOF.
    static String encodeToString(byte[] arr)
    将字节数组Base64编码为字符串
    static String encodeToString(byte[] arr, boolean lineSep)
    将字节数组Base64编码为字符串,可选的CRLF后76字符，除非EOF.
    static String decodeToString(String s)
    将字符串解码BASE64编码为字符串
    static byte[] decode(String s)
    对Base64编码的字符串进行解码
    byte[] decode(char[] arr)
    解码Base64编码的字节数组

## Blowfish加密算法Java实现(Blowfish)

## decode类(Decode)
    static String str2HexStr(String str)
    比较安全的字符串转换
    static String hexStr2Str(String hexStr)
    比较安全的字符串转换

## DES加密(DESUtil)
    static String encrypt(String secretKey,String plainText)
    DES加密
    static String decode(String secretKey,String encryptText)
    DES解密

## 安全散列算法(SecureHA)
    static String getResult(String inputStr)
    将字符串通过安全散列算法加密


# 文件类(file)
## 提供对字符串的全角->半角,半角->全角转换(BCConvert)
    static final char DBC_CHAR_START = 33   半角! ASCII表中可见字符从!开始，偏移位值为33(Decimal)
    static final char DBC_CHAR_END = 126    半角! ASCII表中可见字符到~结束，偏移位值为126(Decimal)
    static final char SBC_CHAR_START = 65281全角! 全角对应于ASCII表的可见字符从！开始，偏移值为65281
    static final char SBC_CHAR_END = 65374  全角! 全角对应于ASCII表的可见字符到～结束，偏移值为65374
    static final int CONVERT_STEP = 65248   全角半角转换间隔! ASCII表中除空格外的可见字符与对应的全角字符的相对偏移
    static final char SBC_SPACE = 12288     全角空格 12288! 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理
    static final char DBC_SPACE = ' '       半角空格! 半角空格的值，在ASCII中为32(Decimal)

    static String bj2qj(String src)
    半角字符->全角字符转换
    只处理空格，!到˜之间的字符，忽略其他
    static String qj2bj(String src)
    全角字符->半角字符转换
    只处理全角的空格，全角！到全角～之间的字符，忽略其他

## 文件编码的工具函数(FileEncodingUtil)
    static void convert(String fileName, String fromCharsetName, String toCharsetName)
    把指定文件或目录转换成指定的编码
    static void convert(File file, String fromCharsetName, String toCharsetName)
    把指定文件或目录转换成指定的编码
    static void convert(String fileName, String fromCharsetName, String toCharsetName, FilenameFilter filter)
    把指定文件或目录转换成指定的编码
    static void convert(File file, String fromCharsetName, String toCharsetName, FilenameFilter filter)
    把指定文件或目录转换成指定的编码
    static String getFileContentFromCharset(File file, String fromCharsetName)
    以指定编码方式读取文件，返回文件内容
    static void saveFile2Charset(File file, String toCharsetName, String content)
    以指定编码方式写文本文件，存在会覆盖
## 文件相关的算法实现(FileImpl)
    static boolean found    = false     以下方式利用mozilla的jchardet作为探测工具
    static String  encoding = null      如果完全匹配某个字符集检测算法, 则该属性保存该字符集的名称. 否则(如二进制文件)其值就为默认值 null, 这时应当查询属性

    static String simpleEncoding(String fileName)
    利用文件头特征判断文件的编码方式
    static String guestFileEncoding(File file)
    传入一个文件(File)对象，检查文件编码
    static String guestFileEncoding(File file, int languageHint)
    获取文件的编码
    static String guestFileEncoding(String path)
    获取文件的编码
    static String guestFileEncoding(String path, int languageHint)
    获取文件的编码

## 封装了几种常用的文件读的方法(FileReadImpl)
    static void copyFileWithChannel(File source, File target)
    利用FileChannel直接实现文件的对拷,对于大文件速度特别明显
    static void copyFileWithBuffer(File source, File target)
    使用FileChannel+Buffer实现文件的读取拷贝是一种极佳的方案
    static void customBufferBufferedStreamCopy(File source, File target)
    利用Buffer实现文件的读取拷贝
    static void customBufferStreamCopy(File source, File target)
    利用Buffer实现文件的读取拷贝
## 利用文件头来实现的一些文件类型的方法封装(FileTypeImpl)
    FILE_TYPE_MAP       获取文件格式对应的哈希值
    static String getFileType(File file)
    获取文件类型,包括图片,若格式不是已配置的,则返回null

## 对比俩个字符串的相似度(StringImpl)
    static double SimilarDegree(String strA, String strB)
    快速比较俩个字符串的相似度
    static double SimilarityRatio(String str, String target)
    获取字符串的相似度
    static String simpleEncoding(String str)
    获取字符串编码


# FTP类
## FTP文件熟悉(FileAttr)
    String fileName         文件名
    Date ModifyTime         上传时间
    Long   size             文件大小

## 包装FTP的相关的信息(FTPConfig)
    String  hostName                主机名
    int     port                    端口号
    String  username                用户名
    String  password                密码
    String  remoteDir               远程路径
    String  localDir                本地路径
    String  remoteEncoding          远程编码
    boolean passiveMode             是否是被动模式
    FTPConfig(String hostName, int port, String username, String password, String remoteDir, String localDir,String remoteEncoding, boolean passiveMode)
    有参构造函数

## FTP状态码以及描述(FTPConstant)

## FTP上传日志(FTPLog)
    String host                     主机
    String operation                操作
    int    ReplyCode                返回code
    String localFile                本地文件
    String remoteFile               远程文件
    String ReplyCodeDesc            返回描述
    String createTime               创建时间

## FTP工具类(FTPUtil接口, FTPUtilImpl实现类)
    boolean isExists(String fileName)
    判断远程文件是否存在
    boolean downLoad(String fileName)
    下载远程文件
    boolean downLoadDir(String directory)
    下载远程目录
    boolean deleteFile(String fileName)
    删除远程文件
    boolean deleteDir(String directory)
    删除远程目录
    boolean putFile(String fileName, String remoteFileName, boolean isDelete)
    上传本地文件到远程目录
    boolean putFile(File file, String remoteFileName, boolean isDelete)
    上传本地文件到远程目录
    boolean putDir(String fileName, String remoteDir)
    上传本地目录到远程
    boolean putDir(File file, String remoteDir)
    上传本地目录到远程
    boolean mkDir(String destory)
    创建文件夹
    List<String> listFile(String directory)
    获取远程文件列表
    LinkedList<String> listDir(String direcotyr)
    获取远程文件夹的目录结构
     Map<String,FileAttr> listFileAttr(String directory)
    获取远程文件属性以Map形式返回
    boolean changeWorkDir(String directory)
    改变FTP连接的工作目录
    String getWorkDir()
    获取当前连接的工作目录
    boolean changName(String oldName, String newName)
    重命名文件
    FTPClient client()
    返回FTPCliend对象(已经打开连接)
    void destory()
    释放所有的资源


# 分页工具类(page)
## 定义起始数与限定数类(RowBounds)
    final int offset                        起始数
    final int limit                         限定数量
    RowBounds()                             无参构造函数
    RowBounds(int offset, int limit)        有参构造函数

## 分页公共类(Pagination)
    transient int offset                    起始数
    transient int limit                     限定数
    int total                               查询总数
    int size                                每页数量
    int pages                               总页数
    int current                             当前页码
    transient boolean searchCount           是否查找总数
    transient boolean openSort              是否开启排序
    transient List<String> ascs             正序的字段名List
    transient List<String> descs            倒叙的字段名List
    transient boolean isAsc                 是否正序
    transient String orderByField           正序的字段
    Pagination()
    无参构造函数
    Pagination(int current, int size)
    有参构造函数
    Pagination(int current, int size, boolean searchCount)
    有参构造函数
    Pagination(int current, int size, boolean searchCount, boolean openSort)
    有参构造函数

## 分页搜索类(Page)
    List<T> records                         搜索记录
    transient Map<String, Object> condition 搜索条件
    Page()
    无参构造函数
    Page(int current, int size)
    有参构造函数
    Page(int current, int size, String orderByField)
    有参构造函数
    Page(int current, int size, String orderByField, boolean isAsc)
    有参构造函数

## 分页返回值类(PageInfo)
    List<T> rows                            结果集
    long total                              总数
    PageInfo(Page<T> page)                  有参构造函数


# 数组工具类(ArrayUtil)
## 常量方法
    static int doueleBitCount(double dd)
    获取一个double类型的数字的小数位有多长
    static Integer[] doubleBitCount(double[] arr)
    获取一组double类型的数字的小数位数的数组


# CharsetUtil字符串相关的工具类
## 常量字段
    static String    GBK             中文超大字符集
    static String    ISO_8859_1      ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1
    static String    US_ASCII        7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块
    static String    UTF_16          16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识
    static String    UTF_16BE        16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序
    static String    UTF_16LE        16 位 UCS 转换格式，Little-endian（最高地址存放低位字节）字节顺序
    static String    UTF_8           8 位 UCS 转换格式

## 常量方法
    static String changeCharset(String str, String newCharset)
    字符串编码转换的实现方法
    static String changeCharset(String str, String oldCharset, String newCharset)
    字符串编码转换的实现方法
    static String toASCII(String str)
    将字符编码转换成US-ASCII码
    static String toGBK(String str)
    将字符编码转换成GBK码
    static String toISO_8859_1(String str)
    将字符编码转换成ISO-8859-1码
    static String toUTF_16(String str)
    将字符编码转换成UTF-16码
    static String toUTF_16BE(String str)
    将字符编码转换成UTF-16BE码
    static String toUTF_16LE(String str)
    将字符编码转换成UTF-16LE码
    static String toUTF_8(String str)
    将字符编码转换成UTF-8码


# 对象有效性校验类(CheckUtil)
## 常用方法
    static boolean isDate(String date,String format)
    判断字符串是否是指定格式的时间
    static boolean valid(String src)
    判断字符串是否为空
    static boolean valid(String... src)
    判断一组字符串是否为空
    static boolean valid(Object obj)
    判断一个对象是否为空
    static boolean valid(Object... objs)
    判断一组对象是否为空
    static boolean valid(Collection col)
    判断集合是否为空
    static boolean valid(Collection... cols)
    判断一组集合是否为空
    static boolean valid(Map map)
    判断map是否为空
    static boolean valid(Map... maps)
    判断一组map是否有效


# cookie的读写
## 常用方法
    static String getCookieValue(HttpServletRequest request, String cookieName)
    获取到cookie的值，不编码
    static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder)
    获取到cookie的值，是否编码
    static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString)
    获取到cookie的值，编码参数（指定编码）
    static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue)
    设置cookie的值，不设置生效时间默认浏览器关闭即失效，也不编码
    static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage)
    设置cookie的值，在指定时间内生效，但不编码
    static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, boolean isEncode)
    设置cookie的值，不设置生效时间，但编码
    static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, boolean isEncode)
    设置cookie的值，在指定时间内生效，编码参数
    static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, String encodeString)
    设置cookie的值，在指定时间内生效，编码参数（指定编码）
    static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName)
    删除Cookie带cookie域名
    static final void doSetCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, boolean isEncode)
    设置Cookie的值，并使其在指定时间内生效 **私有**
    static final void doSetCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, String encodeString)
    设置Cookie的值，并使其在指定时间内生效 **私有**
    static final String getDomainName(HttpServletRequest request)
    得到cookie的域名 **私有**


# DateUtil日期时间相关的工具类
## 常量方法
    static Date calculate(Date date, int second, String timeBurst)
    时间Date在时间段(例如每天的08:00-18:00)上增加或减去second秒
    static Date calculate(String date, int second, String timeBurst)
    时间Date在时间段(例如每天的08:00-18:00)上增加或减去second秒
    static String Date()
    获取当前的日期
    static String Date(Date date)
    将指定的时间格式化成出返回
    static Date Date(String dateStr)
    将指定的字符串解析为时间类型
    static String DateTime()
    获取当前日期时间
    static String DateTime(Date date)
    将指定的时间格式化成出返回
    static Date DateTime(String datestr)
    将指定的字符串解析为时间类型
    static Date day(Date date, int day)
    在指定的时间上加或减去几天
    static Date day(int day)
    在当前时间的基础上加或减去几天
    static Date hour(Date date, float hour)
    在制定的时间上加或减去几小时-支持浮点数
    static Date hour(float hour)
    在当前时间的基础上加或减去几小时-支持浮点数
    static boolean isDate(String date)
    判断字符串是否为日期字符串
    static Date Minute(Date date, int minute)
    在制定的时间上加或减去几分钟
    static Date Minute(int minute)
    在当前时间的基础上加或减去几分钟
    static Date month(Date date, int month)
    在指定的时间上加或减去几月
    static Date month(int month)
    在当前时间的基础上加或减去几月
    static int subDay(Date startTime, Date endTime)
    获取俩个时间之前的相隔的天数
    static int subDay(String startTime, String endTime)
    获取俩个时间之前的相隔的天数
    static long subtimeBurst(Date startDate, Date endDate, String timeBurst)
    返回俩个时间在时间段(例如每天的08:00-18:00)的时长-单位秒
    static long subtimeBurst(String startDate, String endDate, String timeBurst)
    返回俩个时间在时间段(例如每天的08:00-18:00)的时长-单位秒
    static long Subtract(Date date1, Date date2)
    时间date1和date2的时间差-单位秒
    static long Subtract(String date1, String date2)
    时间date1和date2的时间差-单位秒
    static String SubtractDate(String date1, String date2)
    获取俩个时间的查结果用时秒表示
    static int SubtractDay(Date date1, Date date2)
    时间date1和date2的时间差-单位天
    static int SubtractDay(String date1, String date2)
    时间date1和date2的时间差-单位天
    static int SubtractHour(Date date1, Date date2)
    时间date1和date2的时间差-单位小时
    static int SubtractHour(String date1, String date2)
    时间date1和date2的时间差-单位小时
    static int SubtractMinute(Date date1, Date date2)
    时间date1和date2的时间差-单位分钟
    static int SubtractMinute(String date1, String date2)
    时间date1和date2的时间差 -单位分钟
    static int SubtractMonth(Date date1, Date date2)
    时间date1和date2的时间差-单位月
    static int SubtractMonth(String date1, String date2)
    时间date1和date2的时间差-单位月
    static String SubtractTime(String date1, String date2)
    获取俩个时间的查结果用时秒表示
    static int SubtractYear(Date date1, Date date2)
    时间date1和date2的时间差-单位年
    static int SubtractYear(String date1, String date2)
    时间date1和date2的时间差-单位年
    static String Time()
    获取当前的时间
    static String Time(Date date)
    讲指定的时间格式化成出返回
    static Date  Time(String dateStr)
    将指定的字符串解析为时间类型
    static Date  year(Date date, int year)
    在指定的时间上加或减去几年
    static Date  year(int year)
    在当前时间的基础上加或减去year年


# EmailUtilEmail相关的工具类
## 常量方法
    void   doSendHtmlEmail(String subject, String sendHtml, String receiveUser)
    发送邮件
    void   doSendHtmlEmail(String subject, String sendHtml, String receiveUser, File attachment)
    发送邮件


# 文件相关的工具类(FileUtil)
## 常量方法
    static boolean appendLine(File file, String str)
    在文件末尾追加一行
    static boolean cleanFile(File file)
    快速清空一个超大的文件
    static boolean copy(File file, String targetFile)
    复制文件 通过该方式复制文件文件越大速度越是明显
    static boolean copy(String resourcePath, String targetPath)
    复制文件
    static void copyDir(File filePath, String targetPath)
    复制目录
    static void copyDir(String filePath, String targetPath)
    复制目录
    static int countLines(File file)
    获取文件的行数
    static String cpdetector(File file)
    获取文件的编码(cpDetector)探测
    static boolean createFiles(String filePaht)
    创建文件支持多级目录
    static void createPaths(String paths)
    创建多级目录
    static boolean deleteBigFile(File file)
    快速的删除超大的文件
    static boolean deleteDir(File file)
    删除一个目录
    static boolean deleteFile(File file)
    删除一个文件
    static String FileType(File file)
    获取文件的类型
    static String hash(File file)
    获取文件的Hash
    static List<String> Lines(File file)
    以列表的方式获取文件的所有行
    static List<String> Lines(File file, int lines)
    以列表的方式获取文件的指定的行数数据
    static List<File> listFile(File path)
    罗列指定路径下的全部文件
    static List<File> listFile(String path)
    罗列指定路径下的全部文件
    static List<File> listFileAll(File path)
    罗列指定路径下的全部文件包括文件夹
    static List<File> listFileFilter(File dirPath, String postfixs)
    获取指定目录下的特点文件,通过后缀名过滤
    static String MimeType(String file)
    获取文件的Mime类型
    static Date modifyTime(File file)
    获取文件最后的修改时间
    static List<File> searchFile(File dirPath, String fileName)
    在指定的目录下搜寻文个文件
    static List<File> searchFileReg(File dirPath, String reg)
    查找符合正则表达式reg的的文件
    static String SimpleEncoding(String file)
    利用简单的文件头字节特征探测文件编码


# HttpClientUtil
## 常用方法
    static String doGet(String url, Map<String, String> param)
    get方式请求数据
    static String doGet(String url)
    get请求数据(无参数)
    static String doPost(String url, Map<String, String> param)
    post方式请求数据
    static String doPost(String url)
    post方式请求数据(无参数)
    static String doPostJson(String url, String json)
    post方式请求数据(json参数方式)


# Json转换工具类
## 常用方法
	static <T> String toJsonString(List<T> list)
	将List对象序列化为JSON文本
	static String toJsonString(Object object)
	将对象序列化为JSON文本
	static List toArrayList(Object object)
	将对象转换为List
	static Collection toCollection(Object object)
	将对象转换为Collection对象
	static HashMap toHashMap(Object object)
	将对象转换为HashMap
	static List<Map<String, Object>> toList(Object object)
	将对象转换为List
	static <T> T toBean(JSONObject jsonObject, Class<T> beanClass)
	将JSON对象转换为传入类型的对象
	static <T> T toBean(Object object, Class<T> beanClass)
	将对象转换为传入类型的对象
	static <T, D> T toBean(String jsonString, Class<T> mainClass, String detailName, Class<D> detailClass)
	将JSON文本反序列化为主从关系的实体
	static <T, D1, D2> T toBean(String jsonString, Class<T> mainClass, String detailName1, Class<D1> detailClass1, String detailName2, Class<D2> detailClass2)
	将JSON文本反序列化为主从关系的实体
	static <T, D1, D2, D3> T toBean(String jsonString, Class<T> mainClass, String detailName1, Class<D1> detailClass1, String detailName2, Class<D2> detailClass2, String detailName3, Class<D3> detailClass3)
	将JSON文本反序列化为主从关系的实体
	static <T> T toBean(String jsonString, Class<T> mainClass, HashMap<String, Class> detailClass)
	将JSON文本反序列化为主从关系的实体


# 常用的属性文件相关的方法(PropertiesUtil)
## 常用方法
    static String key(String key)
    从系统属性文件中获取相应的值
    static String GetValueByKey(String filePath, String key)
    从文件中根据Key读取Value
    static Map<String,String> GetAllProperties(String filePath)
    读取Properties的全部信息
    static void WriteProperties(String filePath, String pKey, String pValue)
    写入Properties信息


# 随机操作工具类(RandomUtil)
## 常量方法
    static int getNotSimple(int[] param, int len)
    每次生成的len位数都不相同
    static String LowerString(int length)
    返回一个定长的随机纯大写字母字符串(只包含大小写字母)
    static String MixString(int length)
    返回一个定长的随机纯字母字符串(只包含大小写字母)
    static String number(int length)
    static String String(int length)
    返回一个定长的随机字符串(只包含大小写字母、数字)
    static String toFixdLengthString(int num, int fixdlenth)
    根据数字生成一个定长的字符串，长度不够前面补0
    static String toFixdLengthString(long num, int fixdlenth)
    根据数字生成一个定长的字符串，长度不够前面补0
    static String UpperString(int length)
    返回一个定长的随机纯小写字母字符串(只包含大小写字母)
    static String ZeroString(int length)
    生成一个定长的纯0字符串


# 正则相关的工具类(RegUtil)
## 常量方法
    static boolean isNumeric(String src)
    判断是否数字表示
    static boolean isABC(String src)
    判断是否纯字母组合
    static boolean isFloatNumeric(String src)
    判断是否浮点数字表示
    static boolean isMatche(String str, String reg)
    判断字符串str是否符合正则表达式reg
    static int countSubStrReg(String str, String reg)
    获取符合reg正则表达式的字符串在String中出现的次数
    static boolean validateEmail(String email)
    验证邮箱是否有效
    static boolean validateMobile(String mobile)
    验证手机是否有效
    static boolean validateTel(String tel)
    验证固定电话是否有效
    static boolean validateName(String name)
    验证姓名是否有效
    static boolean validateIdCard(String idCardNumber)
    验证身份证是否有效
    static boolean validateBankCardNumber(String bankCardNumber)
    验证银行卡是否有效
    static boolean validatePostalCode(String postalCode)
    验证邮编是否有效


# StringUtil字符串相关的工具类
## 常量方法
    static int ChineseLength(String str)
    获取一个字符串中中文字符的个数
    static int countSubStr(String string, String str)
    获取字符串str在String中出现的次数
    static int countSubStrReg(String string, String reg)
    获取符合reg正则表达式的字符串在String中出现的此时
    String cpDetector(String str)
    获取字符串的编码
    static String formatFloat(float f, String format)
    格式化一个float
    static String full2Half(String str)
    全角字符变半角字符
    static String GBToUnicode(String input)
    GBK转换成Unicode字符集
    static String getHideEmailPrefix(String email)
    隐藏邮件地址前缀。
    static String getLimitLengthString(String str, int len, String symbol)
    截取字符串　超出的字符用symbol代替
    static int getStringLen(String SrcStr)
    取得字符串的实际长度（考虑了汉字的情况）
    static String html(String content)
    HTML标签转义方法 —— java代码库
    static boolean isABC(String src)
    判断是否纯字母组合
    static boolean isChinese(char c)
    判断是否是中文
    static boolean isChinese(String strName)
    完整的判断中文汉字和符号
    static boolean isEmail(String email)
    static boolean isEmpty(String s)
    判断是否是空字符串 null和"" 都返回 true
    static boolean isFloatNumeric(String src)
    判断是否浮点数字表示
    static boolean isIn(String substring, String[] source)
    判断字符串数组中是否包含某字符串元素
    static boolean isInteger(String str)
    static boolean isMessyCode(String strName)
    判断是否是乱码
    static boolean isNumeric(String src)
    判断是否数字表示
    static boolean isNumericString(String src)
    判断是否数字表示
    static String joinString(List array, String symbol)
    把string array or list用给定的符号symbol连接成一个字符串
    static String joinString(String[] array, String symbol)
    把string array or list用给定的符号symbol连接成一个字符串
    static String left(String input, int count)
    截取字符串左侧指定长度的字符串
    static String listToStringSlipStr(List list, String slipStr)
    将list 用传入的分隔符组装为String
    static String middle(String input, int index, int count)
    从指定位置开始截取指定长度的字符串
    static Map<String, String> parseQuery(String query, char split1, char split2, String dupLink)
    解析字符串返回map键值对(例：a=1&b=2 => a=1,b=2)
    static List<String> parseString2ListByCustomerPattern(String pattern, String src)
    根据指定的字符把源字符串分割成一个数组
    static String repeat(String src, int num)
    repeat - 通过源字符串重复生成N次组成新的字符串。
    static String replaceAll(String s, String sf, String sb)
    存文本替换
    static String replaceBlank(String str)
    页面中去除字符串中的空格、回车、换行符、制表符
    static String replaceBracketStr(String str)
    全角括号转为半角
    static boolean requals(String str1, String str2)
    static String right(String input, int count)
    截取字符串右侧指定长度的字符串
    static double SimilarDegree(String str1, String str2)
    字符串相似度比较(速度较快)
    static double SimilarityRatio(String str1, String str2)
    字符串相似度比较(速度较快)
    String SimpleEncoding(String str)
    获取字符串的编码
    static String string2Unicode(String string)
    static String subStringNotEncode(String subject, int size)
    讲字符串截取到指定长度size+...的形式
    static String subStrNotEncode(String subject, int size)
    截取字符，不转码
    static String trimPunct(String str)
    删除所有的标点符号
    static String unicode2String(String unicode)
    static String UnicodeToGB(String input)
    Unicode转换成GBK字符集


# 获取系统信息相关的工具方法(SysUtil)
## 常用变量
    static final String JVM_VERSION                 JVM版本
    static final String JVM_ENCODING                JVM的编码
    static String OS_ARCH                           主机架构
    static String OS_NAME                           主机类型
    static String OS_VERSION                        主机类型版本
    static String SUN_DESKTOP                       操作系统类型
    static String CURRENT_USER                      当前用户
    static String CURRENT_USER_HOME                 当前用户的家目录
## 常用方法
    static long usedMemory()
    已使用的物理内存
    static long JVMtotalMem()
    获取JVM内存总量
    static long JVMfreeMem()
    虚拟机空闲内存量
    static long JVMmaxMem()
    虚拟机使用最大内存量
    static void setHttpProxy(String host, String port, String username, String password)
    设置HTTP代理
    static void setHttpProxy(String host, String port)
    设置HTTP代理




## 获取异常的堆栈信息

## 各种id生成策略
* 图片名生成
* 商品id生成

## 自定义响应结构

## jedis操作

## 常用工具类
* 对url字符串编码
* 对url字符串解码
* 获取客户端ip地址
* 获取当前系统时间
* 生成32位编码，不含横线
* 生成MD5编码 2种
* 空字符转为null
* 手机号中间四位替换成星号
* 手机号中间四位自定义替换
* 邮箱地址加星号
* 账号中间四位自定义替换
* 读取jsonResult的value的某个属性值
* 获取时间戳作为递增Id
* 解析出Url参数中的键值对
* 生成随机密码




# ClassUtil-Class与反射相关的一些工具类

## 常量方法
    static java.util.List<java.lang.String>    getClassName(java.lang.String packageName, boolean childPackage)
    static java.lang.String[]  getField(java.lang.String className)
    获取指定类的全部属性字段
    static java.lang.String[]  getMethod(java.lang.String className)
    获取对象的全部方法
    static void    getter(java.lang.Object obj, java.lang.String att)
    调用对象的getter方法
    static java.lang.String    initStr(java.lang.String old)
    java.lang.Class    loadClass(java.lang.String className)
    加载指定的类
    static <T> T   propertiesCopy(java.lang.Object obj, java.lang.Class<T> type)
    同名属性值复制 将对象obj内属性名同类型T内容有同名属性的值复制到类型T中，并返回一个类型T的对象
    static <T> T   propertiesCopyIgnore(java.lang.Object obj, java.lang.Class<T> type)
    同名属性值复制（忽略大小写） 将对象obj内属性名同类型T内容有同名属性的值复制到类型T中，并返回一个类型T的对象
    static <T> T   propertiesCopyIgnoreFilter(java.lang.Object obj, java.lang.Class<T> type, java.lang.String IgnoreStr)
    同名属性值复制（比较时忽略字符IgnoreStr的内容） 将对象obj内属性名同类型T内容有同名属性的值复制到类型T中，并返回一个类型T的对象
    static void    setter(java.lang.Object obj, java.lang.String att, java.lang.Object value, java.lang.Class<?> type)
    调用对象的setter方法
# ChinesUtil中文相关的工具类

## 常量方法
    static java.lang.String    getFirstSpell(java.lang.String chinese)
    获取汉字串拼音首字母，英文字符不变
    static java.lang.String    getFullSpell(java.lang.String chinese)
    获取汉字串拼音，英文字符不变
    static java.lang.String    getPingYin(java.lang.String inputString)
    将字符串中的中文转化为拼音,其他字符不变
    static boolean isChinese(java.lang.String strName)
    static boolean isChineseByName(java.lang.String str)
    static boolean isChineseByREG(java.lang.String str)
    static void    main(java.lang.String[] args)
# ConvertUtil转换相关的工具类

## 常量方法
    static int bytesToInt(byte[] bytes)
    static long    byteToLong(byte[] b)
    static short   byteToShort(byte[] b)
    static byte[]  intToByte(int i)
    static byte[]  longToByte(long number)
    static byte[]  shortToByte(short number)


# FilePathUtil文件路径相关的工具类

## 常量方法
    static java.lang.String    commandPath(java.lang.String file)
    返回一个通用的文件路径
    static java.lang.String    getParentPath(java.lang.String file)
    返回相一个目录的对于本身的相对父目录


# PrintUtil打印相关的工具类
## 常量方法
    static void    print(java.util.Enumeration enums)
    遍历打印Enumeration
    static void    print(java.util.List<?> list)
    遍历打印遍历List集合
    static void    print(java.util.Map map)
    遍历打印Map集合
    static void    print(java.lang.String str)
    static void    println(java.lang.Object obj)
    static void    println(java.lang.String str)

# ProUtil属性文件相关的工具类
## 常量方法
    static java.lang.String    GetAllProperties(java.lang.String filePath)
    读取Properties的全部信息
    static java.lang.String    GetValueByKey(java.lang.String filePath, java.lang.String key)
    根据Key读取Value
    static java.lang.String    key(java.lang.String key)
    static void    WriteProperties(java.lang.String filePath, java.lang.String pKey, java.lang.String pValue)
    写入Properties信息

# SecUtil安全相关的工具类
## 常量方法
    static java.lang.String    FileMD5(java.io.File file)
    static java.lang.String    md5(java.lang.String password)
# StreamUtil-Stream相关的工具类
## 常量方法
    static java.io.InputStream byte2InputStream(byte[] b)
    static byte[]  inputStream2Byte(java.io.InputStream inStream)
    static byte[]  stream2Byte(java.io.InputStream is)
    void   streamSaveAsFile(java.io.InputStream is, java.io.File outfile)
    将流另存为文件
    static java.lang.String    streamToString(java.io.InputStream in)
    Read an input stream into a string

# WebUtilWeb相关的工具类
## 常量方法
    static java.lang.String    escape(java.lang.String src)
    static java.lang.String    getParamValue(java.lang.String url, java.lang.String paramName)
    static void    main(java.lang.String[] args)
    static void    print(javax.servlet.http.HttpServletRequest request)
    static java.lang.String    removeParam(java.lang.String url, java.lang.String... paramNames)
    static java.lang.String    removeParam(java.lang.String url, java.lang.String paramName)
    static java.lang.String    setParam(java.lang.String url, java.lang.String paramName, java.lang.String paramValue)
    static java.lang.String    unescape(java.lang.String src)
    static java.lang.String    urlJoin(java.net.URL url, java.lang.String locationHeader)
# ZIPUtil-zip相关的工具类
## 常量方法
    static void    deCompress(java.io.File file, java.lang.String dest)
    文档压缩
    static void    unCompress(java.io.File source, java.lang.String path)
    文档解压
    static void    zipFile(java.io.File inFile, java.util.zip.ZipOutputStream zos, java.lang.String dir)