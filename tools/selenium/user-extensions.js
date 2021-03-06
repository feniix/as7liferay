Selenium.prototype.getCurrentDay = function() {
	var date = new Date();

	return date.getDate();
};

Selenium.prototype.getCurrentMonth = function() {
	var date = new Date();
	
	var month = new Array(12);

	month[0] = "January";
	month[1] = "February";
	month[2] = "March";
	month[3] = "April";
	month[4] = "May";
	month[5] = "June";
	month[6] = "July";
	month[7] = "August";
	month[8] = "September";
	month[9] = "October";
	month[10] = "November";
	month[11] = "December";

	return month[date.getMonth()];
};

Selenium.prototype.getCurrentYear = function() {
	var date = new Date();

	return date.getFullYear();
};

Selenium.prototype.getFirstNumber = function(value) {
	return parseInt(value.replace(/.*?(\d+).*$/, '$1'), 10);
};

Selenium.prototype.getIncrementedText = function(locator) {
	var locationValue = this.getText(locator);

	return this.getFirstNumber(locationValue) + 1;
};

Selenium.prototype.isPartialText = function(locator, value) {
	var locationValue = this.getText(locator);
	var index = locationValue.search(value);

	return (index != -1);
};