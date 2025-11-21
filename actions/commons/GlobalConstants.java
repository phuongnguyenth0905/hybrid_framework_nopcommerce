package commons;

public class GlobalConstants {
	public static final String ROOT_FOLDER = System.getProperty("user.dir");//PROJECT_LOCATION
	public static final String DEV_URL = "https://demo.nopcommerce.com/";
	public static final String TEST_URL = "https://test.nopcommerce.com/";
	public static final String STAGING_URL = "https://staging.nopcommerce.com/";
	public static final String UPLOAD_FOLDER_NAME = ROOT_FOLDER + "\\uploadFiles";
	public static final String DOWNLOAD_FOLDER_NAME = ROOT_FOLDER + "\\downloadFiles";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String DB_URL="jdbc:mysql://localhost:1234";
	public static final String DB_NAME="testauto";
	public static final String DB_USER="root";
	public static final String DB_PASS="admin";
	public static final String JAVA_VERSION=System.getProperty("java.version");
	public static final String OS_NAME=System.getProperty("os.name");
	
	public static final String BROWSER_LOG_FOLDER = ROOT_FOLDER + getDirectorySlash("browserLog");
	
	public static String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}

	public static boolean isWindows() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("nix") >= 0 || GlobalConstants.OS_NAME.toLowerCase().indexOf("nux") >= 0 || GlobalConstants.OS_NAME.toLowerCase().indexOf("aix") >= 0);
	}

	public static boolean isSolaris() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("sunos") >= 0);
	}
}
