package com.electroeing.completion_date;

public class CompletionDateParams {
    private final String eng_pgm_ind;
    private final String ma_status;
    private final String maeffdte;
    private final String mhdte9;
    private final String mastatusdte;
    private final String task_type;
    private final int recurring_task_bool;
    private final Integer maspeccyc_em;
    private final Integer bl_req_sched_initial_qt_cycles;
    private final Integer bl_req_sched_interval_qt_cycles;
    private final Integer maspecmin_em;
    private final Integer bl_req_sched_initial_qt_hours;
    private final Integer bl_req_sched_interval_qt_hours;
    private final Integer maspecdays_em;
    private final Integer bl_req_sched_initial_qt_cdy;
    private final Integer bl_req_sched_interval_qt_cdy;
    private final Integer maacninsmin_em;
    private final Integer maacninscyc_em;
    private final int manewmin_em;
    private final int manewcyc_em;
    private final String ma_thresh_found_flag;
    private final String mod_file_status;

    public CompletionDateParams(String eng_pgm_ind, String ma_status, String maeffdte, String mhdte9, String mastatusdte, String task_type, int recurring_task_bool, Integer maspeccyc_em, Integer bl_req_sched_initial_qt_cycles, Integer bl_req_sched_interval_qt_cycles, Integer maspecmin_em, Integer bl_req_sched_initial_qt_hours, Integer bl_req_sched_interval_qt_hours, Integer maspecdays_em, Integer bl_req_sched_initial_qt_cdy, Integer bl_req_sched_interval_qt_cdy, Integer maacninsmin_em, Integer maacninscyc_em, int manewmin_em, int manewcyc_em, String ma_thresh_found_flag, String mod_file_status) {
        this.eng_pgm_ind = eng_pgm_ind;
        this.ma_status = ma_status;
        this.maeffdte = maeffdte;
        this.mhdte9 = mhdte9;
        this.mastatusdte = mastatusdte;
        this.task_type = task_type;
        this.recurring_task_bool = recurring_task_bool;
        this.maspeccyc_em = maspeccyc_em;
        this.bl_req_sched_initial_qt_cycles = bl_req_sched_initial_qt_cycles;
        this.bl_req_sched_interval_qt_cycles = bl_req_sched_interval_qt_cycles;
        this.maspecmin_em = maspecmin_em;
        this.bl_req_sched_initial_qt_hours = bl_req_sched_initial_qt_hours;
        this.bl_req_sched_interval_qt_hours = bl_req_sched_interval_qt_hours;
        this.maspecdays_em = maspecdays_em;
        this.bl_req_sched_initial_qt_cdy = bl_req_sched_initial_qt_cdy;
        this.bl_req_sched_interval_qt_cdy = bl_req_sched_interval_qt_cdy;
        this.maacninsmin_em = maacninsmin_em;
        this.maacninscyc_em = maacninscyc_em;
        this.manewmin_em = manewmin_em;
        this.manewcyc_em = manewcyc_em;
        this.ma_thresh_found_flag = ma_thresh_found_flag;
        this.mod_file_status = mod_file_status;
    }

    public String getEng_pgm_ind() {
        return eng_pgm_ind;
    }

    public String getMa_status() {
        return ma_status;
    }

    public String getMaeffdte() {
        return maeffdte;
    }

    public String getMhdte9() {
        return mhdte9;
    }

    public String getMastatusdte() {
        return mastatusdte;
    }

    public String getTask_type() {
        return task_type;
    }

    public int getRecurring_task_bool() {
        return recurring_task_bool;
    }

    public Integer getMaspeccyc_em() {
        return maspeccyc_em;
    }

    public Integer getBl_req_sched_initial_qt_cycles() {
        return bl_req_sched_initial_qt_cycles;
    }

    public Integer getBl_req_sched_interval_qt_cycles() {
        return bl_req_sched_interval_qt_cycles;
    }

    public Integer getMaspecmin_em() {
        return maspecmin_em;
    }

    public Integer getBl_req_sched_initial_qt_hours() {
        return bl_req_sched_initial_qt_hours;
    }

    public Integer getBl_req_sched_interval_qt_hours() {
        return bl_req_sched_interval_qt_hours;
    }

    public Integer getMaspecdays_em() {
        return maspecdays_em;
    }

    public Integer getBl_req_sched_initial_qt_cdy() {
        return bl_req_sched_initial_qt_cdy;
    }

    public Integer getBl_req_sched_interval_qt_cdy() {
        return bl_req_sched_interval_qt_cdy;
    }

    public Integer getMaacninsmin_em() {
        return maacninsmin_em;
    }

    public Integer getMaacninscyc_em() {
        return maacninscyc_em;
    }

    public int getManewmin_em() {
        return manewmin_em;
    }

    public int getManewcyc_em() {
        return manewcyc_em;
    }

    public String getMa_thresh_found_flag() {
        return ma_thresh_found_flag;
    }

    public String getMod_file_status() {
        return mod_file_status;
    }


    public static final class CompletionDateParamsBuilder {
        private String eng_pgm_ind;
        private String ma_status;
        private String maeffdte;
        private String mhdte9;
        private String mastatusdte;
        private String task_type;
        private int recurring_task_bool;
        private Integer maspeccyc_em;
        private Integer bl_req_sched_initial_qt_cycles;
        private Integer bl_req_sched_interval_qt_cycles;
        private Integer maspecmin_em;
        private Integer bl_req_sched_initial_qt_hours;
        private Integer bl_req_sched_interval_qt_hours;
        private Integer maspecdays_em;
        private Integer bl_req_sched_initial_qt_cdy;
        private Integer bl_req_sched_interval_qt_cdy;
        private Integer maacninsmin_em;
        private Integer maacninscyc_em;
        private int manewmin_em;
        private int manewcyc_em;
        private String ma_thresh_found_flag;
        private String mod_file_status;

        private CompletionDateParamsBuilder() {
        }

        public static CompletionDateParamsBuilder aCompletionDateParams() {
            return new CompletionDateParamsBuilder();
        }

        public CompletionDateParamsBuilder withEng_pgm_ind(String eng_pgm_ind) {
            this.eng_pgm_ind = eng_pgm_ind;
            return this;
        }

        public CompletionDateParamsBuilder withMa_status(String ma_status) {
            this.ma_status = ma_status;
            return this;
        }

        public CompletionDateParamsBuilder withMaeffdte(String maeffdte) {
            this.maeffdte = maeffdte;
            return this;
        }

        public CompletionDateParamsBuilder withMhdte9(String mhdte9) {
            this.mhdte9 = mhdte9;
            return this;
        }

        public CompletionDateParamsBuilder withMastatusdte(String mastatusdte) {
            this.mastatusdte = mastatusdte;
            return this;
        }

        public CompletionDateParamsBuilder withTask_type(String task_type) {
            this.task_type = task_type;
            return this;
        }

        public CompletionDateParamsBuilder withRecurring_task_bool(int recurring_task_bool) {
            this.recurring_task_bool = recurring_task_bool;
            return this;
        }

        public CompletionDateParamsBuilder withMaspeccyc_em(Integer maspeccyc_em) {
            this.maspeccyc_em = maspeccyc_em;
            return this;
        }

        public CompletionDateParamsBuilder withBl_req_sched_initial_qt_cycles(Integer bl_req_sched_initial_qt_cycles) {
            this.bl_req_sched_initial_qt_cycles = bl_req_sched_initial_qt_cycles;
            return this;
        }

        public CompletionDateParamsBuilder withBl_req_sched_interval_qt_cycles(Integer bl_req_sched_interval_qt_cycles) {
            this.bl_req_sched_interval_qt_cycles = bl_req_sched_interval_qt_cycles;
            return this;
        }

        public CompletionDateParamsBuilder withMaspecmin_em(Integer maspecmin_em) {
            this.maspecmin_em = maspecmin_em;
            return this;
        }

        public CompletionDateParamsBuilder withBl_req_sched_initial_qt_hours(Integer bl_req_sched_initial_qt_hours) {
            this.bl_req_sched_initial_qt_hours = bl_req_sched_initial_qt_hours;
            return this;
        }

        public CompletionDateParamsBuilder withBl_req_sched_interval_qt_hours(Integer bl_req_sched_interval_qt_hours) {
            this.bl_req_sched_interval_qt_hours = bl_req_sched_interval_qt_hours;
            return this;
        }

        public CompletionDateParamsBuilder withMaspecdays_em(Integer maspecdays_em) {
            this.maspecdays_em = maspecdays_em;
            return this;
        }

        public CompletionDateParamsBuilder withBl_req_sched_initial_qt_cdy(Integer bl_req_sched_initial_qt_cdy) {
            this.bl_req_sched_initial_qt_cdy = bl_req_sched_initial_qt_cdy;
            return this;
        }

        public CompletionDateParamsBuilder withBl_req_sched_interval_qt_cdy(Integer bl_req_sched_interval_qt_cdy) {
            this.bl_req_sched_interval_qt_cdy = bl_req_sched_interval_qt_cdy;
            return this;
        }

        public CompletionDateParamsBuilder withMaacninsmin_em(Integer maacninsmin_em) {
            this.maacninsmin_em = maacninsmin_em;
            return this;
        }

        public CompletionDateParamsBuilder withMaacninscyc_em(Integer maacninscyc_em) {
            this.maacninscyc_em = maacninscyc_em;
            return this;
        }

        public CompletionDateParamsBuilder withManewmin_em(int manewmin_em) {
            this.manewmin_em = manewmin_em;
            return this;
        }

        public CompletionDateParamsBuilder withManewcyc_em(int manewcyc_em) {
            this.manewcyc_em = manewcyc_em;
            return this;
        }

        public CompletionDateParamsBuilder withMa_thresh_found_flag(String ma_thresh_found_flag) {
            this.ma_thresh_found_flag = ma_thresh_found_flag;
            return this;
        }

        public CompletionDateParamsBuilder withMod_file_status(String mod_file_status) {
            this.mod_file_status = mod_file_status;
            return this;
        }

        public CompletionDateParams build() {
            return new CompletionDateParams(eng_pgm_ind, ma_status, maeffdte, mhdte9, mastatusdte, task_type, recurring_task_bool, maspeccyc_em, bl_req_sched_initial_qt_cycles, bl_req_sched_interval_qt_cycles, maspecmin_em, bl_req_sched_initial_qt_hours, bl_req_sched_interval_qt_hours, maspecdays_em, bl_req_sched_initial_qt_cdy, bl_req_sched_interval_qt_cdy, maacninsmin_em, maacninscyc_em, manewmin_em, manewcyc_em, ma_thresh_found_flag, mod_file_status);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CompletionDateParams{");
        sb.append("eng_pgm_ind='").append(eng_pgm_ind).append('\'');
        sb.append(", ma_status='").append(ma_status).append('\'');
        sb.append(", maeffdte='").append(maeffdte).append('\'');
        sb.append(", mhdte9='").append(mhdte9).append('\'');
        sb.append(", mastatusdte='").append(mastatusdte).append('\'');
        sb.append(", task_type='").append(task_type).append('\'');
        sb.append(", recurring_task_bool=").append(recurring_task_bool);
        sb.append(", maspeccyc_em=").append(maspeccyc_em);
        sb.append(", bl_req_sched_initial_qt_cycles=").append(bl_req_sched_initial_qt_cycles);
        sb.append(", bl_req_sched_interval_qt_cycles=").append(bl_req_sched_interval_qt_cycles);
        sb.append(", maspecmin_em=").append(maspecmin_em);
        sb.append(", bl_req_sched_initial_qt_hours=").append(bl_req_sched_initial_qt_hours);
        sb.append(", bl_req_sched_interval_qt_hours=").append(bl_req_sched_interval_qt_hours);
        sb.append(", maspecdays_em=").append(maspecdays_em);
        sb.append(", bl_req_sched_initial_qt_cdy=").append(bl_req_sched_initial_qt_cdy);
        sb.append(", bl_req_sched_interval_qt_cdy=").append(bl_req_sched_interval_qt_cdy);
        sb.append(", maacninsmin_em=").append(maacninsmin_em);
        sb.append(", maacninscyc_em=").append(maacninscyc_em);
        sb.append(", manewmin_em=").append(manewmin_em);
        sb.append(", manewcyc_em=").append(manewcyc_em);
        sb.append(", ma_thresh_found_flag='").append(ma_thresh_found_flag).append('\'');
        sb.append(", mod_file_status='").append(mod_file_status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
