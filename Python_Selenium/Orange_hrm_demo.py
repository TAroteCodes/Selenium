from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
#from selenium.webdriver.chrome.service import Service
#serv_obj= Service("C:\\Users\\lenovo\\AppData\\Local\\Programs\\Python\\Python310\\Scripts\\chromedriver.exe")
#driver = webdriver.Chrome(service=serv_obj)
driver = webdriver.Chrome()

driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
driver.maximize_window()
driver.implicitly_wait(10)
driver.find_element(By.NAME,"username").send_keys("Admin")
driver.find_element(By.XPATH,"//*[@placeholder='Password']").send_keys("admin123")
driver.find_element(By.XPATH,"//*[@type='submit']").click()
title = driver.title
print(title)
driver.find_element(By.XPATH,"//*[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]").click()
driver.find_element(By.CLASS_NAME,"oxd-userdropdown-link").click()


