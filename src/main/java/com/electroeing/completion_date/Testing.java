package com.electroeing.completion_date;

import java.util.Arrays;
import java.util.Optional;

public class Testing {
    public static void main(String[] args) {

    }

    public static String getCompletionDate(String eng_pgm_ind, String ma_status, String maeffdte,
                                     String mhdte9, String mastatusdte, String task_type,
                                     int recurring_task_bool, Integer maspeccyc_em,
                                     Integer bl_req_sched_initial_qt_cycles, Integer bl_req_sched_interval_qt_cycles,
                                     Integer maspecmin_em, Integer bl_req_sched_initial_qt_hours,
                                     Integer bl_req_sched_interval_qt_hours, Integer maspecdays_em, Integer bl_req_sched_initial_qt_cdy,
                                     Integer bl_req_sched_interval_qt_cdy, Integer maacninsmin_em, Integer maacninscyc_em,
                                     int manewmin_em, int manewcyc_em, String ma_thresh_found_flag, String mod_file_status) {
        String completionDate = null;
        int checkCond = 0;
        if (eng_pgm_ind.equals("E")) {
            if (ma_status.equals("C")) {
                completionDate = firstDefined(maeffdte, mhdte9, mastatusdte);
            } else if (Arrays.asList("ACFT", "COMP").contains(task_type)) {
                if (Arrays.asList("B", "A", "H", "O", "S").contains(ma_status) && recurring_task_bool == 1) {
                    if (condition1(maspeccyc_em, bl_req_sched_initial_qt_cycles, bl_req_sched_interval_qt_cycles, maspecmin_em, bl_req_sched_initial_qt_hours, bl_req_sched_interval_qt_hours, maspecdays_em, bl_req_sched_initial_qt_cdy, bl_req_sched_interval_qt_cdy)) {
                        completionDate = null;
                        checkCond = 1;
                    } else if (condition2(maspeccyc_em, bl_req_sched_initial_qt_cycles, bl_req_sched_interval_qt_cycles, maspecmin_em, bl_req_sched_initial_qt_hours, bl_req_sched_interval_qt_hours, maspecdays_em, bl_req_sched_initial_qt_cdy, bl_req_sched_interval_qt_cdy)) {
                        completionDate = firstDefined(maeffdte, mhdte9, mastatusdte);
                        checkCond = 1;
                    }
                }

                if (checkCond == 0) {
                    if (Arrays.asList("O", "S").contains(ma_status) && recurring_task_bool == 0) {
                        completionDate = null;
                    } else if (condition3(task_type, ma_status, maacninsmin_em, maspecmin_em, maacninscyc_em, maspeccyc_em)) {
                        completionDate = null;
                    } else if (condition4(task_type,ma_status, manewmin_em, maspecmin_em, manewcyc_em, maspeccyc_em, ma_thresh_found_flag)) {
                        completionDate = null;
                    } else if ("W".equals(ma_status) && mastatusdte != null) {
                        completionDate = mastatusdte;
                    } // Here is an elsif that is commented in the given code
                    else if (Arrays.asList("O", "A", "H", "S", "R", "X").contains(ma_status) && firstDefined(ma_thresh_found_flag, "").equals("Y") && recurring_task_bool == 1) {
                        completionDate = firstDefined(maeffdte, mhdte9, mastatusdte, null);
                    } else if (Arrays.asList("N", "D").contains(ma_status) && firstDefined(new String[]{ma_thresh_found_flag, ""}).equals("Y")) {
                        completionDate = firstDefined(maeffdte, mhdte9, mastatusdte, null);
                    } else if (task_type.equals("ACFT") && Arrays.asList("O", "A", "H", "S","R").contains(ma_status) && firstDefined(ma_thresh_found_flag, "").equals("N") && recurring_task_bool == 1) {
                        completionDate = null;
                    }
                }
            }
        } else if (eng_pgm_ind.equals("P")) {
            if (task_type.equals("ACFT") && Arrays.asList("O", "A", "H", "S", "R", "X", "N", "D").contains(ma_status) && maacninsmin_em <= 1 && maspecmin_em > 1) {
                completionDate = null;
            } else if (task_type.equals("ACFT") && Arrays.asList("O", "A", "H", "S", "R", "X", "N", "D").contains(ma_status) && maacninscyc_em <= 1 && maspeccyc_em > 1) {
                completionDate = null;
            } else if ("COMP".equals(task_type) && firstDefined(mod_file_status, "").equals("C") && recurring_task_bool == 1) {
                completionDate = firstDefined(maeffdte, mhdte9, mastatusdte);
            } else if (Arrays.asList("O", "S").contains(ma_status) && recurring_task_bool == 0) {
                completionDate = null;
            } else if (task_type.equals("ACFT") && Arrays.asList("B", "A", "O", "S").contains(ma_status)
                    && (maacninsmin_em > 1 || maacninscyc_em > 1 )) {
                completionDate = firstDefined(maeffdte, mhdte9, mastatusdte);
            } else if ("COMP".equals(task_type) && Arrays.asList("B", "A", "O", "S").contains(ma_status)
                    && (manewmin_em > 1 || manewcyc_em > 1 )) {
                completionDate = firstDefined(maeffdte, mhdte9, mastatusdte);
            } else if (ma_status.equals("W")&& mastatusdte != null) {
                completionDate = mastatusdte;
            } // Commented line here
            else if (task_type.equals("ACFT") && Arrays.asList("O", "A", "H", "S", "R", "X", "N", "D", "C").contains(ma_status)
                    && firstDefined(ma_thresh_found_flag, "").equals("N") && recurring_task_bool == 1) {
                completionDate = null;
            } else if ("COMP".equals(task_type) && Arrays.asList("O", "A", "H", "S", "R", "X", "N", "D", "C").contains(ma_status)
                    && (firstDefined(ma_thresh_found_flag, "").equals("N") || (manewmin_em <= 1 && manewcyc_em <= 1)) && recurring_task_bool == 1) {
                completionDate = null;
            } else if (Arrays.asList("D", "N", "X").contains(ma_status) && firstDefined(ma_thresh_found_flag, "").equals("N")) {
                completionDate = null;
            } else if (Arrays.asList("D", "N", "X").contains(ma_status) && firstDefined(ma_thresh_found_flag, "").equals("Y")) {
                completionDate = maeffdte;
            } else if (Arrays.asList("O", "A", "H", "S", "R", "C").contains(ma_status) && firstDefined(ma_thresh_found_flag, "").equals("Y") && recurring_task_bool == 1) {
                completionDate = firstDefined(maeffdte, mhdte9, null);
            } // Commented lines of code
        }


        return completionDate;
    }


    private String getCompletionDateRefactored(String eng_pgm_ind, String ma_status, String maeffdte,
                                     String mhdte9, String mastatusdte, String task_type,
                                     int recurring_task_bool, Integer maspeccyc_em,
                                     Integer bl_req_sched_initial_qt_cycles, Integer bl_req_sched_interval_qt_cycles,
                                     Integer maspecmin_em, Integer bl_req_sched_initial_qt_hours,
                                     Integer bl_req_sched_interval_qt_hours, Integer maspecdays_em, Integer bl_req_sched_initial_qt_cdy,
                                     Integer bl_req_sched_interval_qt_cdy,
                                     int manewmin_em, int manewcyc_em, String ma_thresh_found_flag, String mod_file_status) {
        if (eng_pgm_ind.equals("E")) {
            if (ma_status.equals("C")) {
                return firstDefined(maeffdte, mhdte9, mastatusdte);
            }
            if ("COMP".equals(task_type)) {
                if (Arrays.asList("B", "A", "H", "O", "S").contains(ma_status) && recurring_task_bool == 1) {
                    if (condition1(maspeccyc_em, bl_req_sched_initial_qt_cycles, bl_req_sched_interval_qt_cycles, maspecmin_em, bl_req_sched_initial_qt_hours, bl_req_sched_interval_qt_hours, maspecdays_em, bl_req_sched_initial_qt_cdy, bl_req_sched_interval_qt_cdy)) {
                        return null;
                    }
                    if (condition2(maspeccyc_em, bl_req_sched_initial_qt_cycles, bl_req_sched_interval_qt_cycles, maspecmin_em, bl_req_sched_initial_qt_hours, bl_req_sched_interval_qt_hours, maspecdays_em, bl_req_sched_initial_qt_cdy, bl_req_sched_interval_qt_cdy)) {
                        return firstDefined(maeffdte, mhdte9, mastatusdte);
                    }
                }
                if (Arrays.asList("O", "S").contains(ma_status) && recurring_task_bool == 0) {
                    return null;
                }
                if (condition4Refactored(ma_status, manewmin_em, maspecmin_em, manewcyc_em, maspeccyc_em, ma_thresh_found_flag)) {
                    return null;
                }
                if ("W".equals(ma_status) && mastatusdte != null) {
                    return mastatusdte;
                }
                if (Arrays.asList("O", "A", "H", "S", "R", "X").contains(ma_status) && Optional.ofNullable(ma_thresh_found_flag).orElse("").equals("Y") && recurring_task_bool == 1) {
                    return firstDefined(maeffdte, mhdte9, mastatusdte, null);
                }
                if (Arrays.asList("N", "D").contains(ma_status) && Optional.ofNullable(ma_thresh_found_flag).orElse("").equals("Y")) {
                    return firstDefined(maeffdte, mhdte9, mastatusdte, null);
                }
            }
        } else if (eng_pgm_ind.equals("P")) {
            if ("COMP".equals(task_type) && Optional.ofNullable(mod_file_status).orElse("").equals("C") && recurring_task_bool == 1) {
                return firstDefined(maeffdte, mhdte9, mastatusdte);
            }
            if (Arrays.asList("O", "S").contains(ma_status) && recurring_task_bool == 0) {
                return null;
            }
            if ("COMP".equals(task_type) && Arrays.asList("B", "A", "O", "S").contains(ma_status)
                    && (manewmin_em > 1 || manewcyc_em > 1 )) {
                return firstDefined(maeffdte, mhdte9, mastatusdte);
            }
            if ("W".equals(ma_status) && mastatusdte != null) {
                return mastatusdte;
            }
            if ("COMP".equals(task_type) && Arrays.asList("O", "A", "H", "S", "R", "X", "N", "D", "C").contains(ma_status)
                    && (Optional.ofNullable(ma_thresh_found_flag).orElse("").equals("N") || (manewmin_em <= 1 && manewcyc_em <= 1)) && recurring_task_bool == 1) {
                return null;
            }
            if (Arrays.asList("D", "N", "X").contains(ma_status) && Optional.ofNullable(ma_thresh_found_flag).orElse("").equals("N")) {
                return null;
            }
            if (Arrays.asList("D", "N", "X").contains(ma_status) && Optional.ofNullable(ma_thresh_found_flag).orElse("").equals("Y")) {
                return maeffdte;
            }
            if (Arrays.asList("O", "A", "H", "S", "R", "C").contains(ma_status) && Optional.ofNullable(ma_thresh_found_flag).orElse("").equals("Y") && recurring_task_bool == 1) {
                return firstDefined(maeffdte, mhdte9, null);
            }
        }


        return null;
    }

    private static boolean condition1(Integer maspeccyc_em, Integer bl_req_sched_initial_qt_cycles,
                               Integer bl_req_sched_interval_qt_cycles, Integer maspecmin_em,
                               Integer bl_req_sched_initial_qt_hours, Integer bl_req_sched_interval_qt_hours,
                               Integer maspecdays_em, Integer bl_req_sched_initial_qt_cdy, Integer bl_req_sched_interval_qt_cdy) {
        return (
                    isDefined(maspeccyc_em) && maspeccyc_em > 0
                    && maspeccyc_em.equals(firstDefined(bl_req_sched_initial_qt_cycles, 0))
                    && !maspeccyc_em.equals(firstDefined(bl_req_sched_interval_qt_cycles, 0))
                ) || (
                        isDefined(maspecmin_em) && maspecmin_em > 0
                        && maspecmin_em.equals(firstDefined(bl_req_sched_initial_qt_hours, 0) * 60)
                        && !maspecmin_em.equals(firstDefined(bl_req_sched_interval_qt_hours, 0) * 60)
                ) || (
                        isDefined(maspecdays_em) && maspecdays_em > 0
                        && maspecdays_em.equals(firstDefined(bl_req_sched_initial_qt_cdy, 0))
                        && !maspecdays_em.equals(firstDefined(bl_req_sched_interval_qt_cdy, 0))
                );
    }

    private static boolean condition2(Integer maspeccyc_em, Integer bl_req_sched_initial_qt_cycles,
                               Integer bl_req_sched_interval_qt_cycles, Integer maspecmin_em,
                               Integer bl_req_sched_initial_qt_hours, Integer bl_req_sched_interval_qt_hours,
                               Integer maspecdays_em, Integer bl_req_sched_initial_qt_cdy, Integer bl_req_sched_interval_qt_cdy) {
        return (
                isDefined(maspeccyc_em) && maspeccyc_em > 0
                        && !maspeccyc_em.equals(firstDefined(bl_req_sched_initial_qt_cycles, 0))
                        && maspeccyc_em.equals(firstDefined(bl_req_sched_interval_qt_cycles, 0))
                        && isDefined(bl_req_sched_initial_qt_cycles)
        ) || (
                isDefined(maspecmin_em) && maspecmin_em > 0
                        && !maspecmin_em.equals(firstDefined(bl_req_sched_initial_qt_hours, 0) * 60)
                        && maspecmin_em.equals(firstDefined(bl_req_sched_interval_qt_hours, 0) * 60)
                        && isDefined(bl_req_sched_initial_qt_hours)
        ) || (
                isDefined(maspecdays_em) && maspecdays_em > 0
                        && !maspecdays_em.equals(firstDefined(bl_req_sched_initial_qt_cdy, 0))
                        && maspecdays_em.equals(firstDefined(bl_req_sched_interval_qt_cdy, 0))
                        && isDefined(bl_req_sched_initial_qt_cdy)
        );
    }

    private static boolean condition3(String task_type, String ma_status, int maacninsmin_em, int maspecmin_em, int maacninscyc_em, int maspeccyc_em) {
        return task_type.equals("ACFT") && Arrays.asList("O", "A", "H", "S","R","X","N","D").contains(ma_status)
            && (
                    (maacninsmin_em <= 1 && maspecmin_em > 1)
                    || (maacninscyc_em <= 1 && maspeccyc_em > 1)
            );
    }

    private static boolean condition4(String task_type, String ma_status, int manewmin_em, int maspecmin_em, int manewcyc_em, int maspeccyc_em, String ma_thresh_found_flag) {
        return "COMP".equals(task_type) && Arrays.asList("O", "A", "H", "S", "R", "X", "N", "D").contains(ma_status)
            && (
                    firstDefined(ma_thresh_found_flag, "").equals("N")
                    || (manewmin_em <= 1 && maspecmin_em > 1)
                    || (manewcyc_em <= 1 && maspeccyc_em > 1)
            );
    }

    private static boolean condition4Refactored(String ma_status, int manewmin_em, int maspecmin_em, int manewcyc_em, int maspeccyc_em, String ma_thresh_found_flag) {
        return Arrays.asList("O", "A", "H", "S", "R", "X", "N", "D").contains(ma_status)
            && (
                    Optional.ofNullable(ma_thresh_found_flag).orElse("").equals("N")
                    || (manewmin_em <= 1 && maspecmin_em > 1)
                    || (manewcyc_em <= 1 && maspeccyc_em > 1)
            );
    }

    public static <T> T firstDefined(T ...items) {
        for(T i : items) if(i != null) return i;
        return null;
    }

    private static boolean isDefined(Integer param) {
        return param != null;
    }
}
