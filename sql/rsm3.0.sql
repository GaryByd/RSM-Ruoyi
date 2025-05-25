# 这个数据库是我按照流程图来的，只在流程图基础(流程图的圆柱形框我全部认定为数据库表)上加了部门表，用户表和巡查项表，其余的可以和流程图的圆柱形框一一对应，但是字段也行并不完善，需要酌情添加
create database `ry-vue-temp`;
use `ry-vue-temp`;


# 这两个字段加到若依的sys_user里面
`union_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信小程序开放平台的唯一标识符,如果不涉及多小程序就无视这个字段',
                                `open_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '微信小程序用户唯一标识',


/*#这个是作业计划填报库，是作业导入后的第一站，我认为是记录导入作业的记录
DROP TABLE IF EXISTS `rsm_task_project`;
CREATE TABLE `rsm_task_project`  (
                                     `id` bigint NOT NULL COMMENT '作业id',
                                     `task_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '作业名称',
                                     `type_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
                                     `dept_id` bigint NOT NULL COMMENT '作业班组id',
                                     `dept_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班组名称',
                                     `start_time` datetime NULL DEFAULT NULL COMMENT '作业开始时间',
                                     `end_time` datetime NULL DEFAULT NULL COMMENT '作业结束时间',
                                     `risk_level` enum('A','B','C','D') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业风险等级',
                                     `mandate_holder` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '负责人姓名',
                                     `task_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业描述',
                                     `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                     `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
                                     `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '作业计划填报库表' ROW_FORMAT = DYNAMIC;

#这个是审批，是作业导入后的第二站，是一项作业的风险为B级风险以上的会进来这里进行审批
DROP TABLE IF EXISTS `rsm_task_approval`;
CREATE TABLE `rsm_task_approval`  (
                                      `id` bigint NOT NULL COMMENT '作业id',
                                      `task_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '作业名称',
                                      `type_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
                                      `dept_id` bigint NOT NULL COMMENT '作业班组id',
                                      `dept_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班组名称',
                                      `start_time` datetime NULL DEFAULT NULL COMMENT '作业开始时间',
                                      `end_time` datetime NULL DEFAULT NULL COMMENT '作业结束时间',
                                      `risk_level` enum('A','B','C','D') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业风险等级',
                                      `mandate_holder` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '负责人姓名',
                                      `task_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业描述',
                                      `approval_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '审核状态（1通关 0未审核 2未通过）',
                                      `reviewer` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '负责人姓名',
                                      `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                      `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
                                      `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                      `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
                                      `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '作业审核表' ROW_FORMAT = DYNAMIC;*/

#作业表，通过审核状态字段来判断审核的状态，
DROP TABLE IF EXISTS `rsm_task`;
CREATE TABLE `rsm_task`  (
                             `id` bigint NOT NULL COMMENT '作业id',
                             `task_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '作业名称',
                             `type_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
                             `dept_id` bigint NOT NULL COMMENT '作业班组id',
                             `dept_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班组名称',
                             `start_time` datetime NULL DEFAULT NULL COMMENT '作业开始时间',
                             `end_time` datetime NULL DEFAULT NULL COMMENT '作业结束时间',
                             `risk_id` bigint NOT NULL COMMENT '风险关联id',
                             `mandate_holder` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '负责人姓名',
                             `approval_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '审核状态（1通过 0未审核 2未通过）',
                             `reviewer` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '审核人姓名',
                             `task_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业描述',
                             `position_info` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '位置信息',
                             `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                             `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
                             `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
                             `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '作业表' ROW_FORMAT = DYNAMIC;

# 风险待查库表，是更具导入的作业信息自动生成的可能需要巡查的部分，并且附带可能有什么风险
DROP TABLE IF EXISTS `rsm_unverified_risk`;
CREATE TABLE `rsm_unverified_risk`  (
                                        `id` bigint NOT NULL COMMENT '待查项id',
                                        `unverified_risk_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '待查项名称',
                                        `risk_id` bigint NOT NULL COMMENT '关联风险id',
                                        `risk_type` enum('作业活动','生产现场','设备设施','其他') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
                                        `admin` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '管理员',
                                        `control_standard` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '巡查标准',
                                        `position` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '作业位置名',
                                        `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
                                        `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
                                        `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                        `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
                                        `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '风险待查项表' ROW_FORMAT = Dynamic;

# 风险库
DROP TABLE IF EXISTS `rsm_risk`;
CREATE TABLE `rsm_risk`  (

                             `id` bigint NOT NULL COMMENT '风险id',
                             `risk_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '风险名称',
                             `risk_type` enum('作业风险','生产现场风险','设备风险','其他') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '风险类型',
                             `supervisor` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '监管人员',
                             `control_standard` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '管控标准',
                             `position` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '风险位置名',
                             `risk_level` enum('A','B','C','D') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '风险等级',
                             `risk_info` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '风险信息，作为设备风险则说明是什么设备，作为生产现场风险说明哪些生产现场，作为作业活动说明哪个作业',
                             `risk_relate_id` bigint DEFAULT 0 COMMENT '风险关联id，作为保留字段，如果没有设备表和生产现场表那么这个字段仅在风险类型为作业风险时有用，用于关联作业表',
                             `auditor` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '审核人',
                             `risk_describe` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '风险描述',
                             `risk_conseq` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '风险后果',
                             `control_measure` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '风险管理措施',
                             `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
                             `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
                             `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
                             `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '风险库表' ROW_FORMAT = Dynamic;

#巡查点位置信息
DROP TABLE IF EXISTS `rsm_patrol_point`;
CREATE TABLE `rsm_patrol_point`  (
                                     `id` bigint NOT NULL COMMENT '巡查点id',
                                     `patrol_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡查点名称',
                                     `patrol_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡查点描述',
                                     `position` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '巡查点位置名',
                                     `location_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '具体位置描述',
                                     `security_officer` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '安全员',
                                     `last_patrol_time` datetime NULL DEFAULT NULL COMMENT '最近一次巡查时间',
                                     `patrol_frequency` int NOT NULL DEFAULT 0 COMMENT '巡查次数',
                                     `status` tinyint NULL DEFAULT 0 COMMENT '状态 0-正常 1-停用',
                                     `del_flag` tinyint NULL DEFAULT 0 COMMENT '删除标志（0代表存在 1代表删除）',
                                     `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
                                     `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
                                     `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                     `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '巡查点表' ROW_FORMAT = Dynamic;

# 巡查清单由巡查项构成，用patrol_list_id来记录归属哪个巡查清单，然后万湾说每个巡查项都要有巡查点信息和风险信息，流程图设想的隐患和巡查项挂钩，每个巡查项可以单独提交一次隐患到隐患表，提交完修改status状态
DROP TABLE IF EXISTS `rsm_patrol_item`;
CREATE TABLE `rsm_patrol_item`  (
                                    `id` bigint NOT NULL COMMENT '巡检项id',
                                    `patrol_list_id` bigint NOT NULL COMMENT '巡查清单id',
                                    `patrol_point_id` bigint NOT NULL COMMENT '巡查点id',,
                                    `unverified_risk_id` bigint NOT NULL COMMENT '风险待查库表id',
                                    `responsible_organization` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '责任单位信息',
    `check_item` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '检测项',
    `status` tinyint NULL DEFAULT 0 COMMENT '状态 0-未处理  2-未发现隐患 3-发现隐患',
    `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `handler_img` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '检查图片/隐患图片',
    `handler_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '检查描述/隐患描述',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `list_idx`(`patrol_list_id` ASC) USING BTREE
    ) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '巡检项表' ROW_FORMAT = Dynamic;

#巡查清单表，字段都是记录该巡查一些信息，一些记录的展示则通过status来分类来实现record的效果
DROP TABLE IF EXISTS `rsm_patrol_list`;
CREATE TABLE `rsm_patrol_list`  (
                                    `id` bigint NOT NULL COMMENT '清单id',
                                    `patrol_list_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡查清单名称',
                                    `patrol_list_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡查清单描述',
                                    `classify` tinyint NULL DEFAULT NULL COMMENT '分类 0-安全巡查 1-岗位巡查 2-位置',
                                    `principal_id` bigint NOT NULL COMMENT '负责人id',
                                    `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
                                    `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
                                    `checked_count` int NOT NULL DEFAULT 0 COMMENT '已检查数量',
                                    `hidden_trouble_count` int NOT NULL DEFAULT 0 COMMENT '发现隐患数量',
                                    `finish_time` datetime NULL DEFAULT NULL COMMENT '完成时间',
                                    `status` tinyint NULL DEFAULT 0 COMMENT '状态 0-未完成 1-已完成 2-已过期',
                                    `del_flag` tinyint NULL DEFAULT 0 COMMENT '删除标志（0代表存在 1代表删除）',
                                    `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
                                    `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                    `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
                                    `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '巡查清单表' ROW_FORMAT = Dynamic;

/*#巡查记录表，都是些展示用的信息
DROP TABLE IF EXISTS `rsm_patrol_Record`;
CREATE TABLE `rsm_patrol_Record`  (
                                      `id` bigint NOT NULL COMMENT '记录id',
                                      `patrol_list_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '巡查清单id',
                                      `principal_id` bigint NOT NULL COMMENT '负责人id',
                                      `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
                                      `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
                                      `checked_count` int NOT NULL DEFAULT 0 COMMENT '已检查数量',
                                      `hidden_trouble_count` int NOT NULL DEFAULT 0 COMMENT '发现隐患数量',
                                      `finish_time` datetime NULL DEFAULT NULL COMMENT '完成时间',
                                      `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
                                      `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                      `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                      `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改者',
                                      `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '巡查清单表' ROW_FORMAT = Dynamic;*/

# 随手拍表，通过事件定性和处理时间等字段完成记录的分类
DROP TABLE IF EXISTS `rsm_snapshot`;
CREATE TABLE `rsm_snapshot`  (
                                 `id` bigint NOT NULL COMMENT '随手拍id',
                                 `question_title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '问题标题',
                                 `question_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '问题描述',
                                 `creator_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上传人用户名',
                                 `creator_id` bigint NOT NULL COMMENT '上传人id',
                                 `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系方式',
                                 `img_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '图片路径',
                                 `status` tinyint NULL DEFAULT 0 COMMENT '处理状态 0-未处理 1-处理完成',
                                 `handler` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理人',
                                 `handler_img_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '处理完成的现场的图片路径',
                                 `approval_reply` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审批回复',
                                 `property` tinyint NULL DEFAULT NULL COMMENT '事件定性 0-隐患 1-非隐患',
                                 `handler_time` datetime NULL DEFAULT NULL COMMENT '处理时间',
                                 `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                 `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '随手拍问题表' ROW_FORMAT = Dynamic;

/*#随手拍记录表，按照流程图好像是记录没有被认定为隐患的随手拍
DROP TABLE IF EXISTS `rsm_snapshot_record`;
CREATE TABLE `rsm_snapshot_record`  (
                                        `id` bigint NOT NULL COMMENT '随手拍记录id',
                                        `snapshot_id` bigint NOT NULL COMMENT '随手拍id',
                                        `question_title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '问题标题',
                                        `creator_id` bigint NOT NULL COMMENT '上传人id',
                                        `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系方式',
                                        `question_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '问题描述',
                                        `handler` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审批人',
                                        `approval_reply` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审批回复',
                                        `property` tinyint NULL DEFAULT NULL COMMENT '事件定性 0-隐患 1-非隐患',
                                        `handler_time` datetime NULL DEFAULT NULL COMMENT '处理时间',
                                        `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                        `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                        `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '随手拍记录表' ROW_FORMAT = Dynamic;*/

#隐患表，没什么特别的
DROP TABLE IF EXISTS `rsm_hidden_trouble`;
CREATE TABLE `rsm_hidden_trouble`  (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '隐患id',
                                       `trouble_title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '隐患标题',
                                       `creator_id` bigint NOT NULL COMMENT '创建人id',
                                       `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人联系方式',
                                       `trouble_img_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '隐患图片路径-逗号分隔',
                                       `trouble_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '隐患描述',
                                       `status` tinyint NULL DEFAULT 0 COMMENT '处理状态0-未处理,1-已处理',
                                       `trouble_classify` int NULL DEFAULT 0 COMMENT '隐患分类 0-其他',
                                       `source` tinyint NOT NULL COMMENT '隐患来源 0-巡查 1-随手拍 2-上传',
                                       `relation_id` bigint NULL DEFAULT NULL COMMENT '关联id',
                                       `handler_id` bigint NOT NULL COMMENT '处理人id',
                                       `handle_img_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '处理图片路径',
                                       `rectify_desc` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '整改描述',
                                       `rectify_time` datetime NULL DEFAULT NULL COMMENT '整改时间',
                                       `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                       `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '隐患表' ROW_FORMAT = Dynamic;

# 处理完的隐患库，没什么特别的
DROP TABLE IF EXISTS `rsm_hidden_trouble_record`;
CREATE TABLE `rsm_hidden_trouble_record`  (
                                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '记录id',
                                              `trouble_id` bigint NOT NULL COMMENT '隐患id',
                                              `trouble_title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '隐患标题',
                                              `creator_id` bigint NOT NULL COMMENT '创建人id',
                                              `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人联系方式',
                                              `trouble_img_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '隐患图片路径-逗号分隔',
                                              `trouble_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '隐患描述',
                                              `handler_id` bigint NOT NULL COMMENT '处理人id',
                                              `handle_img_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '处理图片路径',
                                              `rectify_desc` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '整改描述',
                                              `rectify_time` datetime NULL DEFAULT NULL COMMENT '整改时间',
                                              `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                              `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                                              `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '隐患处理记录表' ROW_FORMAT = Dynamic;