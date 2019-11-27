package algorithm.basic.java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * @Author: hypon
 * @Date: 2019/11/21 14:16
 */
public class Java8DateOperate {

    /**
     * 初始化
     * LocalDate LocalTime LocalDateTime
     */
    private static void getDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        LocalDate now = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime custom = LocalDateTime.of(2019, 11, 25, 11, 25, 0);

        //时间的加减运算
        LocalDateTime plusYears = custom.plusYears(1);
        LocalDateTime minusYears = custom.minusYears(1);
        System.out.println("date-->" + date + ",calendar-->" + calendar);
        System.out.println("LocalDate-->" + now + ",localTime-->" + localTime);
        System.out.println("LocalDateTime-->" + dateTime + ",LocalDateTime2-->" + custom);
        System.out.println("plusYears-->" + plusYears + ",minusYears-->" + minusYears);
    }

    /**
     * Instant:时间戳（以unix元年：1970年1月1日 00:00:00 到某个时间之间的毫秒值）
     */
    private static void getInstant() {
        //默认获取UTC时区，不是本地时区
        Instant instant = Instant.now();
        System.out.println("Instant-->" + instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime-->" + offsetDateTime);
        System.out.println("long-->" + instant.toEpochMilli() + ",second-->" + offsetDateTime.toEpochSecond());
    }

    /**
     * Duration : 计算两个时间之间的间隔
     * Period ：计算两个日期之间的间隔
     * <p>
     * 注意：获取间隔时间的时分秒，是指间隔单独时分秒的时间，而不是总和(60s->0m,不是60s->1m)
     */
    private static void getDuration() {
        Instant ins1 = Instant.now();
        Instant ins2 = Instant.now().plusMillis(1000);
        Duration duration = Duration.between(ins1, ins2);
        System.out.println("duration-->" + duration.toMillis());

        LocalTime lt1 = LocalTime.now();
        LocalTime lt2 = LocalTime.now().plusSeconds(1000);
        ;
        Duration duration1 = Duration.between(lt1, lt2);
        System.out.println("duration1-->" + duration1.toMinutes());

        LocalDate ld1 = LocalDate.of(2018, 1, 1);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);
        System.out.println("period-->" + period.getDays());
    }

    /**
     * TemporalAdjuster 时间矫正器，指定时间的运算
     */
    private static void getTemporalAdjuster() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("LocalDateTime-->" + ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println("withDayOfMonth-->" + ldt2);

        LocalDateTime sunday = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("sunday-->" + sunday);

        //自定义：下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dayOfWeek = ldt4.getDayOfWeek();

            if (dayOfWeek.equals(DayOfWeek.THURSDAY)) {
                ldt4 = ldt4.plusDays(4);
            } else if (dayOfWeek.equals(DayOfWeek.SUNDAY)) {
                ldt4 = ldt4.plusDays(2);
            }
            return ldt4;
        });
        System.out.println("getDayOfWeek-->" + ldt5);
    }

    /**
     * DateTimeFormatter ：格式化时间/日期
     */
    private static void getDateTimeFormatter() {
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String strDate1 = dtf1.format(now);
        System.out.println("strDate1-->" + strDate1);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String strDate2 = dtf2.format(now);
        LocalDate parse = LocalDate.parse(strDate2, dtf2);
        System.out.println("strDate2-->" + strDate2 + ",parse-->" + parse);

    }

    /**
     * ZonedDate、ZonedTime、ZonedDateTime
     * <p>
     * 每个时区都对应这ID 地区ID都为"{区域}/{城市}"的格式，例如：Asia/Shanghai
     */
    private static void getZone() {
        //支持所有的时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("getAvailableZoneIds" + availableZoneIds);

        //指定时区
        LocalDateTime zoneNow = LocalDateTime.now(ZoneId.of("America/Curacao"));
        System.out.println("zoneNow-->" + zoneNow);
    }

    public static void main(String[] args) {
        getDate();
        System.out.println("==================");
        getInstant();
        System.out.println("==================");
        getDuration();
        System.out.println("==================");
        getTemporalAdjuster();
        System.out.println("==================");
        getDateTimeFormatter();
        System.out.println("==================");
        getZone();
    }
}


