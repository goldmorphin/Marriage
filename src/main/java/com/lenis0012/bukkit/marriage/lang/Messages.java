package com.lenis0012.bukkit.marriage.lang;

public class Messages {
	private static final LangConfig lang = LangConfig.get();
	
	/** Messages */
	public static final String NO_PERMISSION = lang.getMessageWithDefault("no permission", "Нет разрешения!");
	public static final String NO_CONSOLE = lang.getMessageWithDefault("no console", "Вы должны быть игроком!");
	public static final String NO_REQUEST = lang.getMessageWithDefault("no request", "У Вас нет запросов!");
	public static final String NOT_ONLINE = lang.getMessageWithDefault("not online", "Этот игрок не онлайн!");
	public static final String MARRIED = lang.getMessageWithDefault("married", "{USER1} и {USER2} теперь связаны вечной любовью!");
	public static final String DIVORCED = lang.getMessageWithDefault("divorced", "{USER1} бросил(а) эту сучку {USER2}!");
	public static final String NO_PARTNER = lang.getMessageWithDefault("no partner", "Вы не состоите в браке!");
	public static final String LEFT_CHAT = lang.getMessageWithDefault("left chat", "Вы покинули чат партнёров!");
	public static final String JOINED_CHAT = lang.getMessageWithDefault("joined chat", "Вы зашли в чат партнёров!");
	public static final String GIFT_SENT = lang.getMessageWithDefault("gift sent", "Подарок отправлен!");
	public static final String GIFT_RECEIVED = lang.getMessageWithDefault("gift received", "Вы получили {ITEM} от Вашей второй половинки!");
	public static final String INVALID_ITEM = lang.getMessageWithDefault("invalid item", "Ошибочный предмет у Вас в руке!");
	public static final String NO_HOME = lang.getMessageWithDefault("no home", "Вы ещё не установили точку дома!");
	public static final String HOME_TP = lang.getMessageWithDefault("home tp", "Перемещение домой! Вуху :)");
	public static final String NO_PARTNERS = lang.getMessageWithDefault("no partners", "Пар на нашем сервере пока нет :(");
	public static final String REQUEST_SENT = lang.getMessageWithDefault("request sent", "Запрос отправлен! Ждите...");
	public static final String NOT_YOURSELF = lang.getMessageWithDefault("not yourself", "Женится на себе? Ты нормальный?");
	public static final String ALREADY_MARRIED = lang.getMessageWithDefault("already married", "Вы уже в браке!");
	public static final String HAS_PARTNER = lang.getMessageWithDefault("has partner", "{USER} уже имеет партнёра :(");
	public static final String REQUEST_RECEIVED = lang.getMessageWithDefault("request received", "{USER} хочет вас. \nпропишите {COMMAND} чтобы согласится!");
	public static final String INVALID_PLAYER = lang.getMessageWithDefault("invalid player", "Недействительный игрок!");
	public static final String HOME_SET = lang.getMessageWithDefault("home set", "Дом установлен!");
	public static final String PARTNER_SETHOME = lang.getMessageWithDefault("partner sethome", "Ваш партнёр установил дом!");
	public static final String PARTNER_TELEPORTING = lang.getMessageWithDefault("partner teleporting", "Ваш партнёр хочет телепортироваться к Вам!");
	public static final String GIFT_CREATIVE = lang.getMessageWithDefault("gift creative", "Вы не можете дарить в креатив режиме!");
	public static final String OFFLINE_SINCE = lang.getMessageWithDefault("offline since", "Ваш партнёр оффлайн с {TIME}");
	public static final String ONLINE_SINCE = lang.getMessageWithDefault("online since", "Ваш партнёр онлайн с {TIME}");
	public static final String ALREADY_QUEUED = lang.getMessageWithDefault("already queued", "У Вас уже есть запрос в очереди!");
	public static final String REQUEST_EXPIRED = lang.getMessageWithDefault("request expired", "Ваш запрос истёк!");
	public static final String LEFT_CHATSPY = lang.getMessageWithDefault("left chat", "Вы покинули ChatSpy :)");
	public static final String JOINED_CHATSPY = lang.getMessageWithDefault("joined chat", "Вы зашли в ChatSpy!");
	
	/** Words */
	public static final String PAGE = lang.getWordWithDefault("page", "Стр.");
	public static final String PARTNERS = lang.getWordWithDefault("partners", "Партнёры");
	public static final String TELEPORTING = lang.getWordWithDefault("teleporting", "Перемещение");
	public static final String SECONDS = lang.getWordWithDefault("seconds", "сек");
	public static final String MINUTES = lang.getWordWithDefault("minutes", "мин");
	public static final String HOURS = lang.getWordWithDefault("hours", "часов");
	public static final String DAYS = lang.getWordWithDefault("days", "дней");
	public static final String WEEKS = lang.getWordWithDefault("weeks", "недель");
	public static final String MONTHS = lang.getWordWithDefault("months", "месяцев");
	public static final String YEARS = lang.getWordWithDefault("years", "лет");
}