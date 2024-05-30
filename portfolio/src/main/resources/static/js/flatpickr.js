let maxDate = new Date();
maxDate = maxDate.setMonth(maxDate.getMonth() + 3);

flatpickr('#visitingTime',{
	enableTime: true,
	locale : 'ja',
	minDate : 'today',
	maxDate : maxDate,
	format : 'yyyy/MM/dd HH:mm:ss'
});