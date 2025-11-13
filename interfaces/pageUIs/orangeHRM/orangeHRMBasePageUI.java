package pageUIs.orangeHRM;

public class orangeHRMBasePageUI {
	public static final String DYNAMIC_MENU_LINK = "//a[string()='%s']";
	public static final String DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER = "//h6[contains(normalize-space(),'%s')]/ancestor::div//following-sibling::button[normalize-space()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_LABEL_AT_FORM = "//label[contains(normalize-space(),'%s')]/ancestor::div[contains(@class,'oxd-grid-item')]//input";
	//public static final String DYNAMIC_TEXTBOX_BY_LABEL_AT_FORM = "//label[contains(text(),'%s')]/ancestor::div[contains(@class,'oxd-input-group')]//input";
	public static final String AMOUNT_TEXTBOX_BY_LABEL_AT_FORM = "(//input[@class='oxd-input oxd-input--active'])[6]";//(//label[contains(normalize-space(),'Amount')]/ancestor::div[contains(@class,'oxd-grid-item')]//input)[2]
	
	public static final String DYNAMIC_DROPDOWN_BY_LABEL_AT_FORM = "//label[normalize-space()='%s']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]";
	public static final String DYNAMIC_DROPDOWN_OPTION_BY_TEXT = "//div[@role='listbox']//span[normalize-space()='%s']";

	public static final String DYNAMIC_TOGGLE_SWITCH_BY_LABEL_AT_FORM ="//p[normalize-space()='%s']/ancestor::div[contains(@class,'oxd-form-row')]//span[contains(@class,'oxd-switch-input')]";
	public static final String DYNAMIC_TABLE_COLUMN_NAME_SIBLING="//div[normalize-space()='%s']/preceding-sibling::div";
	public static final String CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX="//input[@type='checkbox']/ancestor::div[contains(@class,'oxd-table-cell')]/following-sibling::div[%s]";//"//input[@value='%s']/ancestor::div[contains(@class,'oxd-table-cell')]/following-sibling::div[1]";

	// Đếm số lượng div đứng trước cột có tên cụ thể (xác định index của cột)
	public static final String TABLE_ORANGEHRM_COLUMN_NAME_SIBLING ="//div[@role='columnheader' and contains(normalize-space(.),'%s')]";

	// Lấy giá trị trong cell dựa theo rowIndex + columnIndex
	public static final String CELL_ORANGEHRM_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX ="(//div[@role='rowgroup']//div[@role='row'])[%s]//div[@role='cell'][%s]";

}
